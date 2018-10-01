package uk.gaz492.perfectspawn;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PerfectSpawn.MODID, name = PerfectSpawn.NAME, version = "@MOD_VERSION@", dependencies = "after:yunomakegoodmap")
public class PerfectSpawn {
    public static final String MODID = "perfectspawn";
    public static final String NAME = "Perfect Spawn";

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
