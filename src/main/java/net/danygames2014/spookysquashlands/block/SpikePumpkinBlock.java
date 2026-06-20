package net.danygames2014.spookysquashlands.block;

import net.danygames2014.spookysquashlands.listener.TextureListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class SpikePumpkinBlock extends TemplateBlock {
    private static final double LAUNCH_FACTOR = 0.5;

    public SpikePumpkinBlock(Identifier identifier, Material material) {
        super(identifier, material);
        setTranslationKey(identifier.namespace, identifier.path);
    }

    @Override
    public void onBlockBreakStart(World world, int x, int y, int z, PlayerEntity player) {
        super.onBlockBreakStart(world, x, y, z, player);
        player.damage(null, 4);
        double xLaunch = getLaunchingMultiplier(x, player.x) * LAUNCH_FACTOR;
        double zLaunch = getLaunchingMultiplier(z, player.z) * LAUNCH_FACTOR;
        player.velocityX += xLaunch;
        player.velocityY += LAUNCH_FACTOR;
        player.velocityZ += zLaunch;
        player.setPositionAndAngles(player.x, player.y, player.z, player.yaw + 180, player.pitch);
    }

    private int getLaunchingMultiplier(int pumpkinCoordinate, double playerCoordinate) {
        double difference = pumpkinCoordinate - playerCoordinate;
        if (difference < 0) {
            return 1;
        } else if (difference > 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public Block setHardness(float hardness) {
        return super.setHardness(hardness);
    }

    public int getTexture(int side, int meta) {
        if (side == 0) {
            return TextureListener.spikePumpkinBottom;
        } else if (side == 1) {
            return TextureListener.spikePumpkinTop;
        }
        return TextureListener.spikePumpkinSide;
    }
}
