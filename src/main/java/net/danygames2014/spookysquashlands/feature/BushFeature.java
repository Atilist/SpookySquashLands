package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class BushFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (y < 64) {
            return false;
        }
        if (random.nextInt(2) != 0) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0) {
            return false;
        }
        for (int offsetX = x - 1 - random.nextInt(4); offsetX <= x + 1 + random.nextInt(4); offsetX++) {
            for (int offsetZ = z - 1 - random.nextInt(4); offsetZ <= z + 1 + random.nextInt(4); offsetZ++) {
                int offsetY = y;
                while (!(world.getBlockId(offsetX, offsetY, offsetZ) == 0 && world.getBlockId(offsetX, offsetY - 1, offsetZ) != 0)) {
                    if (world.getBlockId(offsetX, offsetY - 1, offsetZ) == 0) {
                        offsetY--;
                    } else {
                        offsetY++;
                    }
                }
                world.setBlock(offsetX, offsetY, offsetZ, random.nextInt(8) == 0 ? Block.LOG.id : Block.LEAVES.id);
                world.setBlock(offsetX, offsetY + 1, offsetZ, Block.LEAVES.id);
            }
        }
        world.setBlock(x, y, z, Block.LOG.id);
        world.setBlock(x, y + 1, z, Block.LEAVES.id);
        return true;
    }
}
