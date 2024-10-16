package net.danygames2014.spookysquashlands.block;

import net.danygames2014.spookysquashlands.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class GiantPumpkinTopBlock extends TemplateBlock {
    public GiantPumpkinTopBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
    }

    @Override
    public Block setHardness(float hardness) {
        return super.setHardness(hardness);
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
            case 1:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopTopMiddle;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
            case 2:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopTopRight;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleTopLeft;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleTopRight;
                }
            case 3:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopMiddleLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
            case 4:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopMiddleMiddle;
                }
            case 5:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopMiddleRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }

            case 6:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopBottomLeft;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleTopLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleTopRight;
                }
            case 7:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopBottomMiddle;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleTopMiddle;
                }
            case 8:
                if (side == 1) { // Top
                    return TextureListener.giantPumpkinTopBottomRight;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleTopRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleTopLeft;
                }
        }
        return TextureListener.giantPumpkinFilling;
    }
}
