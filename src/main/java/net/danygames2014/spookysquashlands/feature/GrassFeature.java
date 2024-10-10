package net.danygames2014.spookysquashlands.feature;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class GrassFeature extends Feature {

    public int meta;
    public int iterations;

    /**
     * @param meta 0 is Dead Bush, 1 is Tall Grass
     * @param iterations Vanilla grass is 128
     */
    public GrassFeature(int meta, int iterations) {
        this.meta = meta;
        this.iterations = iterations;
    }

    @Override
    public boolean generate(World world, Random random, int xPos, int yPos, int zPos) {
        for (int i = 0; i < iterations; ++i) {
            int x = xPos + random.nextInt(8) - random.nextInt(8);
            int z = zPos + random.nextInt(8) - random.nextInt(8);
            int y = world.getTopY(x, z);
            if (world.isAir(x, y, z) && Block.GRASS.canGrow(world, x, y, z)) {
                world.setBlockWithoutNotifyingNeighbors(x,y,z, Block.GRASS.id, meta);
            }
        }

        return true;
    }
}
