package net.danygames2014.spookysquashlands.block;

import net.danygames2014.spookysquashlands.listener.BlockListener;
import net.danygames2014.spookysquashlands.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class GiantPumpkinTopBlock extends TemplateBlock {
    public GiantPumpkinTopBlock(Identifier identifier, Material material) {
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
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopTopLeft;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleTopRight;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleTopLeft;
                }
                break;
            case 1:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopTopMiddle;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
                break;
            case 2:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopTopRight;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleTopLeft;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleTopRight;
                }
                break;
            case 3:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopMiddleLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
                break;
            case 4:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopMiddleMiddle;
                }
                break;
            case 5:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopMiddleRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
                break;
            case 6:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopBottomLeft;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleTopLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleTopRight;
                }
                break;
            case 7:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopBottomMiddle;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
                break;
            case 8:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopBottomRight;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleTopRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleTopLeft;
                }
                break;
        }
        return TextureListener.giantPumpkinFilling;
    }
}
