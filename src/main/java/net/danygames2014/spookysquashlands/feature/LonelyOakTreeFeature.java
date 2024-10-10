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
        placeLeaves(world, random, x, treeHeight, z);
        for (int i = 0; i < 2 + random.nextInt(6); i++) {
            int branchX = x + random.nextInt(9) - 4;
            int branchY = treeHeight + random.nextInt(9) - 4;
            int branchZ = z + random.nextInt(9) - 4;
            int branchBegin = y + random.nextInt(treeHeight - y);
            // Approach X
            int startX;
            int endX;
            if (branchX > x) {
                startX = x;
                endX = branchX;
            } else {
                startX = branchX;
                endX = x;
            }
            for (int j = startX; j <= endX; j++) {
                world.setBlock(j, branchBegin, z, Block.LOG.id);
            }
            // Approach Z
            int startZ;
            int endZ;
            if (branchZ > z) {
                startZ = z;
                endZ = branchZ;
            } else {
                startZ = branchZ;
                endZ = z;
            }
            for (int j = startZ; j <= endZ; j++) {
                world.setBlock(branchX, branchBegin, j, Block.LOG.id);
            }
            // Approach Y
            int startY;
            int endY;
            if (branchY > branchBegin) {
                startY = branchBegin;
                endY = branchY;
            } else {
                startY = branchY;
                endY = branchBegin;
            }
            for (int j = startY; j <= endY; j++) {
                world.setBlock(branchX, j, branchZ, Block.LOG.id);
            }
            // Place leaves at branch end
            placeLeaves(world, random, branchX, branchY, branchZ);
        }
        return true;
    }

    private void placeLeaves(World world, Random random, int x, int y, int z) {
        for (int offsetX = x - 2; offsetX <= x + 2; offsetX++) {
            for (int offsetY = y - 2; offsetY <= y + 2; offsetY++) {
                for (int offsetZ = z - 2; offsetZ <= z + 2; offsetZ++) {
                    if (world.getBlockId(offsetX, offsetY, offsetZ) == 0) {
                        world.setBlock(offsetX, offsetY, offsetZ, Block.LEAVES.id);
                    }
                }
            }
        }
    }
}
