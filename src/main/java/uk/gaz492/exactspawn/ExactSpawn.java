package uk.gaz492.exactspawn;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExactSpawn.MOD_ID)
public class ExactSpawn
{

    public static final String MOD_ID = "exactspawn";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger("Exact Spawn");

    public ExactSpawn() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadCommon);
        ExactSpawnConfig.register();
    }

    private void loadCommon(FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.addListener(this::onEntityJoinWorld);
    }

    private void onEntityJoinWorld(EntityJoinWorldEvent event){
        if(event.getEntity() instanceof ServerPlayerEntity){
            ServerPlayerEntity player = (ServerPlayerEntity) event.getEntity();
            World world = event.getWorld();
            BlockPos playerPos = player.getPosition();

            LOGGER.info("Spawn YAW: " + ExactSpawnConfig.spawnRotationYaw);
            LOGGER.info("Spawn PITCH: " + ExactSpawnConfig.spawnRotationPitch);

            player.connection.setPlayerLocation(player.posX, player.posY, player.posZ, ExactSpawnConfig.spawnRotationYaw, ExactSpawnConfig.spawnRotationPitch);

//            if(playerPos.equals(world.getSpawnPoint())){
//            player.connection.setPlayerLocation(player.posX, player.posY, player.posZ, ExactSpawnConfig.spawnRotationYaw, ExactSpawnConfig.spawnRotationPitch);
//            player.setPositionAndRotation(player.posX, player.posY, player.posZ, ExactSpawnConfig.spawnRotationYaw, ExactSpawnConfig.spawnRotationPitch);
//            }
        }
    }
}
