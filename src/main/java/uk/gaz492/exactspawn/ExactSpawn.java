package uk.gaz492.exactspawn;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExactSpawn.MODID, name = ExactSpawn.NAME, version = "@MOD_VERSION@", dependencies = "after:yunomakegoodmap")
public class ExactSpawn {
    public static final String MODID = "exactspawn";
    public static final String NAME = "Exact Spawn";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        DimensionManager.unregisterDimension(0);
        DimensionManager.registerDimension(0, DimensionType.register("Overworld", "", 0, WorldProviderSurfaceOverride.class, true));
    }

}
