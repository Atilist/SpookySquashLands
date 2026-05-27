package net.danygames2014.spookysquashlands.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class LazySaplingTemplate extends LazyBlockTemplate {
    private final Feature tree;
    private final Random random = new Random();

    public LazySaplingTemplate(Identifier identifier, Material material, float hardness, BlockSoundGroup blockSounds, Feature tree) {
        super(identifier, material, hardness, blockSounds);
        this.tree = tree;
    }

    @Override
    protected int getDroppedItemMeta(int i) {
        return 0;
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public int getRenderType() {
        return 1;
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z) {
        int belowId = world.getBlockId(x, y - 1, z);
        return world.getBlockId(x, y, z) == 0 && (belowId == Block.GRASS_BLOCK.id || belowId == Block.DIRT.id || belowId == Block.FARMLAND.id);
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random) {
        if (world.getBlockMeta(x, y, z) == 15 && random.nextInt(4) == 0) {
            growTree(world, x, y, z, random);
            return;
        }
        if (world.getBlockMeta(x, y, z) < 15) world.setBlockMeta(x, y, z, world.getBlockMeta(x, y, z) + 1);
    }

    private boolean growTree(World world, int x, int y, int z, Random random) {
        world.setBlock(x, y, z, 0, 0);
        if (!tree.generate(world, random, x, y, z)) {
            world.setBlock(x, y, z, this.id, 15);
            return false;
        }
        return true;
    }

    @Override
    public boolean onBonemealUse(World world, int x, int y, int z, BlockState state) {
        return growTree(world, x, y, z, random);
    }
}
