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
        world.setBlock(x, y, z, Block.LOG.id);
        world.setBlock(x, y + 1, z, Block.LEAVES.id);
        return true;
    }
}
