package uk.gaz492.exactspawn;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;

public class ExactSpawnConfig {

    public static float spawnRotationPitch;
    public static float spawnRotationYaw;

    private static Pair<CommonConfig, ForgeConfigSpec> common;


    public static void register()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ExactSpawnConfig::reload);

        common = new ForgeConfigSpec.Builder().configure(CommonConfig::new);

        ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, common.getRight());
    }

    public static void reload(ModConfig.ModConfigEvent event)
    {
        ModConfig config = event.getConfig();

        if (config.getSpec() == common.getRight())
        {
            reloadCommon();
        }
    }

    public static void reloadCommon()
    {
        CommonConfig cfg = common.getLeft();
        spawnRotationPitch = cfg.spawnRotationPitch.get().floatValue();
        spawnRotationYaw = cfg.spawnRotationYaw.get().floatValue();
    }

    private static class CommonConfig {
        private final ForgeConfigSpec.DoubleValue spawnRotationPitch;
        private final ForgeConfigSpec.DoubleValue spawnRotationYaw;

        private CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("General Config").push("general");
            spawnRotationPitch = builder
                    .comment("Sets the player camera angle to look up or down")
                    .translation("exactspawn.general.pitch")
                    .defineInRange("pitch", 0.0, -90.0, 90.0);

            spawnRotationYaw = builder
                    .comment("Sets the player rotation")
                    .translation("exactspawn.general.yaw")
                    .defineInRange("yaw", 0.0, -180, 180);

            builder.pop();
        }
    }
}

