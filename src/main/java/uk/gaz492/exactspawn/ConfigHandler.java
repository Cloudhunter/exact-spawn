package uk.gaz492.exactspawn;

import net.minecraftforge.common.config.Config;

@Config(modid = ExactSpawn.MODID)
public class ConfigHandler {
    public static SubCategory spawnSettings = new SubCategory();

    public static class SubCategory {

        @Config.RequiresWorldRestart
        @Config.Comment({"Sets the player camera angle to look up or down"})
        @Config.RangeDouble(min = -90, max = 90)
        public float spawnRotationPitch;

        @Config.RequiresWorldRestart
        @Config.Comment({"Sets the player rotation"})
        @Config.RangeDouble(min = 0, max = 359)
        public float spawnRotationYaw;
    }
}