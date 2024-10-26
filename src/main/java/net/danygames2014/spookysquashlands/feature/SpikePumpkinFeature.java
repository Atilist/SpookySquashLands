package net.danygames2014.spookysquashlands.feature;

import net.danygames2014.spookysquashlands.listener.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SpikePumpkinFeature extends Feature {

    public boolean generate(World world, Random random, int x, int y, int z) {
        if (random.nextInt(4) != 0) {
            return false;
        }
        if (world.getBlockId(x, y - 1, z) == 0 || world.getBlockId(x, y - 1, z) == Block.ICE.id || world.getBlockId(x, y - 1, z) == Block.LEAVES.id) {
            return false;
        }
        for(int var6 = 0; var6 < 16; ++var6) {
            int var7 = x + random.nextInt(8) - random.nextInt(8);
            int var8 = y + random.nextInt(4) - random.nextInt(4);
            int var9 = z + random.nextInt(8) - random.nextInt(8);
            if (world.isAir(var7, var8, var9) && world.getBlockId(var7, var8 - 1, var9) == Block.GRASS_BLOCK.id && Block.PUMPKIN.canPlaceAt(world, var7, var8, var9)) {
                world.setBlockWithoutNotifyingNeighbors(var7, var8, var9, BlockListener.spikePumpkin.id);
            }
        }

        return true;
    }
}
