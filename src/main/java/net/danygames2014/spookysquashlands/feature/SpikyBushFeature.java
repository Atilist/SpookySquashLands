package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SpikyBushFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (random.nextInt(2) != 0) {
            return false;
        }

        if (!world.getBlockState(x, y - 1, z).isOf(Block.GRASS_BLOCK)) {
            return false;
        }

        world.setBlockState(x, y, z, Block.LOG.getDefaultState());
        world.setBlockState(x, y + 1, z, Block.LEAVES.getDefaultState());
        world.setBlockState(x + 1, y, z, Block.LEAVES.getDefaultState());
        world.setBlockState(x, y, z + 1, Block.LEAVES.getDefaultState());
        world.setBlockState(x - 1, y, z, Block.LEAVES.getDefaultState());
        world.setBlockState(x, y, z - 1, Block.LEAVES.getDefaultState());
        return true;
    }
}
