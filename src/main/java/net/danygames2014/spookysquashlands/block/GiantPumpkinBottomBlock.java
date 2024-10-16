package net.danygames2014.spookysquashlands.block;

import net.danygames2014.spookysquashlands.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class GiantPumpkinBottomBlock extends TemplateBlock {
    public GiantPumpkinBottomBlock(Identifier identifier, Material material) {
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
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomTopLeft;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleBottomRight;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleBottomLeft;
                }
            case 1:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomTopMiddle;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleBottomMiddle;
                }
            case 2:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomTopRight;
                } else if (side == 2) { // X
                    return TextureListener.giantPumpkinMiddleBottomLeft;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleBottomRight;
                }
            case 3:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomMiddleLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleBottomMiddle;
                }
            case 4:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomMiddleMiddle;
                }
            case 5:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomMiddleRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleBottomMiddle;
                }

            case 6:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomBottomLeft;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleBottomLeft;
                } else if (side == 4) { // Z
                    return TextureListener.giantPumpkinMiddleBottomRight;
                }
            case 7:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomBottomMiddle;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleBottomMiddle;
                }
            case 8:
                if (side == 0) { // Bottom
                    return TextureListener.giantPumpkinBottomBottomRight;
                } else if (side == 3) { // -X
                    return TextureListener.giantPumpkinMiddleBottomRight;
                } else if (side == 5) { // -Z
                    return TextureListener.giantPumpkinMiddleBottomLeft;
                }
        }
        return TextureListener.giantPumpkinFilling;
    }
}
