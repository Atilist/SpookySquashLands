package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class HugePumpkinFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (y < 64) {
            return false;
        }
        if (random.nextInt(4) != 0) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0) {
            return false;
        }
        for (int offsetX = x - 1; offsetX <= x + 1; offsetX++) {
            for (int offsetY = y; offsetY <= y + 2; offsetY++) {
                for (int offsetZ = z - 1; offsetZ <= z + 1; offsetZ++) {
                    world.setBlock(offsetX, offsetY, offsetZ, Block.PUMPKIN.id);
                }
            }
        }
        world.setBlock(x, y + 3, z, Block.LOG.id);
        return true;
    }
}
