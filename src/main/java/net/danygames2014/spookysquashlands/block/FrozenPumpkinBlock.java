package net.danygames2014.spookysquashlands.block;

import net.danygames2014.spookysquashlands.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class FrozenPumpkinBlock extends TemplateBlock {
    public FrozenPumpkinBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
    }

    @Override
    public Block setHardness(float hardness) {
        return super.setHardness(hardness);
    }

    public int getTexture(int side, int meta) {
        if (side == 0) {
            return TextureListener.frozenPumpkinBottom;
        } else if (side == 1) {
            return TextureListener.frozenPumpkinTop;
        }
        return TextureListener.frozenPumpkinSide;
    }
}
