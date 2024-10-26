package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class JungleTreeFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (y < 65) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0 || world.getBlockId(x, y - 1, z) == Block.ICE.id || world.getBlockId(x, y - 1, z) == Block.LEAVES.id) {
            return false;
        }
        createTree(world, random, x, y, z, true);
        return true;
    }

    private void createTree(World world, Random random, int x, int y, int z, boolean firstStep) {
        int treeHeight = y + 8 + random.nextInt(12);
        for (int offsetY = y; offsetY <= treeHeight; offsetY++) {
            world.setBlock(x, offsetY, z, Block.LOG.id);
        }
        placeLeaves(world, random, x, treeHeight, z);
        for (int i = 0; i < 6 + random.nextInt(12); i++) {
            int branchX = x + random.nextInt(17) - 8;
            int branchY = treeHeight + random.nextInt(9) - 4;
            int branchZ = z + random.nextInt(17) - 8;
            int currentX = x, currentY = y + random.nextInt(treeHeight - 2 - y) + 2, currentZ = z;
            while (currentX != branchX || currentY != branchY || currentZ != branchZ) {
                world.setBlock(currentX, currentY, currentZ, Block.LOG.id);
                if (currentX > branchX) {
                    currentX--;
                } else if (currentX < branchX) {
                    currentX++;
                }
                if (currentY > branchY) {
                    currentY--;
                } else if (currentY < branchY) {
                    currentY++;
                }
                if (currentZ > branchZ) {
                    currentZ--;
                } else if (currentZ < branchZ) {
                    currentZ++;
                }
            }
            // Place leaves at branch end
            placeLeaves(world, random, branchX, branchY, branchZ);
            if (firstStep && random.nextInt(16) == 0 && branchY < 90) {
                createTree(world, random, branchX, branchY, branchZ, false);
            }
        }
    }

    private void placeLeaves(World world, Random random, int x, int y, int z) {
        for (int offsetX = x - 4; offsetX <= x + 4; offsetX++) {
            for (int offsetY = y - 1; offsetY <= y + 1; offsetY++) {
                for (int offsetZ = z - 4; offsetZ <= z + 4; offsetZ++) {
                    if (world.getBlockId(offsetX, offsetY, offsetZ) == 0) {
                        if ((offsetX == x - 4 || offsetX == x + 4) && (offsetY == y - 1 || offsetY == y + 1) && (offsetZ == z - 4 || offsetZ == z + 4)) {
                            continue;
                        }
                        world.setBlock(offsetX, offsetY, offsetZ, Block.LEAVES.id);
                    }
                }
            }
        }
    }
}
