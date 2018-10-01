package uk.gaz492.perfectspawn;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;

public class WorldProviderSurfaceOverride extends WorldProviderSurface {

    @Override
    public BlockPos getRandomizedSpawnPoint(){
        return new BlockPos(getSpawnPoint());
    }
}