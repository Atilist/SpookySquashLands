package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SpikyBushFeature extends Feature {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        if (!world.getBlockState(x, y - 1, z).isOf(Block.GRASS_BLOCK)) {
            return false;
        }

        setBlock(world, x, y, z, Block.LOG);
        switch (random.nextInt(3)) {
            case 1, 2:
                createLayer(world, x, y, z, 5);

            case 0:
                createLayer(world, x, y, z, 3);
                break;
        }

        return true;
    }

    public void createLayer(World world, int genX, int genY, int genZ, int layerSize) {
        int xStart = genX - ((layerSize - 1) / 2);
        int zStart = genZ - ((layerSize - 1) / 2);

        for (int x = 0; x < layerSize; x++) {
            for (int z = 0; z < layerSize; z++) {
                setBlock(world, xStart + x, genY, zStart + z, Block.LEAVES);
            }
        }

    }

    public void setBlock(World world, int x, int y, int z, Block block) {
        int topY = world.getTopY(x, z);
        if (world.getBlockState(x, topY, z).isAir()) {
            world.setBlockState(x, topY, z, block.getDefaultState());
        }
    }
}
