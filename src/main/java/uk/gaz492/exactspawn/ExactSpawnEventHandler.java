package uk.gaz492.exactspawn;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ExactSpawn.MODID)
public class ExactSpawnEventHandler {

    /**
     * Inject the new values and save to the config file when the config has been changed from the GUI.
     *
     * @param event The event
     */
    @SubscribeEvent
    public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ExactSpawn.MODID)) {
            ConfigManager.sync(ExactSpawn.MODID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayerMP) {
//            Entity player = event.getEntity();
            EntityPlayerMP player = (EntityPlayerMP) event.getEntity();
            World world = event.getWorld();
            BlockPos playerPos = player.getPosition();


            if (playerPos.equals(world.getSpawnPoint())) {
                event.getEntity().setPositionAndRotation(player.posX, player.posY, player.posZ, ConfigHandler.spawnSettings.spawnRotationYaw, ConfigHandler.spawnSettings.spawnRotationPitch);
            }
        }
    }
}
