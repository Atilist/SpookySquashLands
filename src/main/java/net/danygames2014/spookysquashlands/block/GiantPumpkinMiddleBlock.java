package net.danygames2014.spookysquashlands.block;

import net.danygames2014.spookysquashlands.listener.BlockListener;
import net.danygames2014.spookysquashlands.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class GiantPumpkinMiddleBlock extends TemplateBlock {
    public GiantPumpkinMiddleBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
    }

    @Override
    public Block setHardness(float hardness) {
        return super.setHardness(hardness);
    }

    @Override
    protected int getDroppedItemMeta(int blockMeta) {
        return 4;
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random) {
        return BlockListener.giantPumpkinMiddle.id;
    }

    public int getTexture(int side, int meta) {
        switch (meta) {
            case 0:
                if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleMiddleRight;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleMiddleLeft;
                }
                break;
            case 1:
                if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleMiddleMiddle;
                }
                break;
            case 2:
                if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleMiddleLeft;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleMiddleRight;
                }
                break;
            case 3:
                if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleMiddleMiddle;
                }
                break;
            case 4:
                return TextureListener.giantPumpkinFilling;
            case 5:
                if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleMiddleMiddle;
                }
                break;
            case 6:
                if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleMiddleLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleMiddleRight;
                }
                break;
            case 7:
                if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleMiddleMiddle;
                }
                break;
            case 8:
                if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleMiddleRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleMiddleLeft;
                }
                break;
        }
        return TextureListener.giantPumpkinFilling;
    }
}
