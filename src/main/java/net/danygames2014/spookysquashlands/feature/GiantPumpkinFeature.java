package net.danygames2014.spookysquashlands.feature;

import net.danygames2014.spookysquashlands.listener.BlockListener;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class GiantPumpkinFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (y < 65) {
            return false;
        }
        if (random.nextInt(8) != 0) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0) {
            return false;
        }
        for (int offsetX = x - 1, i = 0; offsetX <= x + 1; offsetX++, i++) {
            for (int offsetZ = z - 1, j = 0; offsetZ <= z + 1; offsetZ++, j++) {
                world.setBlock(offsetX, y, offsetZ, BlockListener.giantPumpkinBottom.id, i + j * 3);
                world.setBlock(offsetX, y + 1, offsetZ, BlockListener.giantPumpkinMiddle.id, i + j * 3);
                world.setBlock(offsetX, y + 2, offsetZ, BlockListener.giantPumpkinTop.id, i + j * 3);
            }
        }
        return true;
    }
}
