package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class GlacierFeature extends Feature {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (y < 64) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0) {
            return false;
        }
        for (int offsetX = x - 2 - random.nextInt(6); offsetX <= x + 2 + random.nextInt(6); offsetX++) {
            for (int offsetZ = z - 2 - random.nextInt(6); offsetZ <= z + 2 + random.nextInt(6); offsetZ++) {
                int offsetY = y;
                while (!(world.getBlockId(offsetX, offsetY, offsetZ) == 0 && world.getBlockId(offsetX, offsetY - 1, offsetZ) != 0)) {
                    if (world.getBlockId(offsetX, offsetY - 1, offsetZ) == 0) {
                        offsetY--;
                    } else {
                        offsetY++;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    world.setBlock(offsetX, offsetY + i, offsetZ, Block.ICE.id);
                }
            }
        }
        return true;
    }
}
