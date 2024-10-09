package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class LonelyOakTreeFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (y < 64) {
            return false;
        }
        if (random.nextInt(8) != 0) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0) {
            return false;
        }
        int treeHeight = y + 4 + random.nextInt(8);
        for (int offsetY = y; offsetY <= treeHeight; offsetY++) {
            world.setBlock(x, offsetY, z, Block.LOG.id);
        }
        for (int offsetX = x - 3; offsetX <= x + 3; offsetX++) {
            for (int offsetY = treeHeight - 3; offsetY <= treeHeight + 3; offsetY++) {
                for (int offsetZ = z - 3; offsetZ <= z + 3; offsetZ++) {
                    if (world.getBlockId(offsetX, offsetY, offsetZ) == 0) {
                        world.setBlock(offsetX, offsetY, offsetZ, Block.LEAVES.id);
                    }
                }
            }
        }
        return false;
    }
}
