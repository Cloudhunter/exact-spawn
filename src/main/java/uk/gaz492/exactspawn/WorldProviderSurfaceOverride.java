package uk.gaz492.exactspawn;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;

public class WorldProviderSurfaceOverride extends WorldProviderSurface {

    @Override
    public BlockPos getRandomizedSpawnPoint() {
        return new BlockPos(getSpawnPoint());
    }
}