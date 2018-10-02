package uk.gaz492.exactspawn;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;

@Config(modid = ExactSpawn.MODID)
public class ConfigHandler {
    public static SubCategory spawnSettings = new SubCategory();

    public static class SubCategory {
        @Config.Comment({
                "Allow you to set the pitch and yaw of the player when they spawn",
                "Only works for when they spawn at the global spawn"
        })
        public float spawnRotationPitch;
        public float spawnRotationYaw;
    }
}
