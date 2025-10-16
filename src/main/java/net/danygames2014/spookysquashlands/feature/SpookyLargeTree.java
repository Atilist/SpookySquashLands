package net.danygames2014.spookysquashlands.feature;

import net.danygames2014.spookysquashlands.listener.BlockListener;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.LargeOakTreeFeature;
import net.modificationstation.stationapi.api.util.math.Direction;

public class SpookyLargeTree extends LargeOakTreeFeature {
    @Override
    public boolean canPlace() {
        int[] genPos = new int[]{this.origin[0], this.origin[1], this.origin[2]};
        int[] topBlockPos = new int[]{this.origin[0], this.origin[1] + this.height - 1, this.origin[2]};
        int blockBelowId = this.world.getBlockId(this.origin[0], this.origin[1] - 1, this.origin[2]);

        if (blockBelowId == 2 || blockBelowId == 3) {
            int var4 = this.tryBranch(genPos, topBlockPos);
            if (var4 == -1) {
                this.height = 5 + this.random.nextInt(this.maxTrunkHeight);
                return true;
            } else if (var4 < 6) {
                return false;
            } else {
                this.height = var4;
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public void placeCluster(int x, int y, int z, float shape, byte majorAxis, int clusterBlock) {
        int var7 = (int) ((double) shape + 0.618);
        byte var8 = MINOR_AXES[majorAxis];
        byte var9 = MINOR_AXES[majorAxis + 3];
        int[] genPos = new int[]{x, y, z};
        int[] placePos = new int[]{0, 0, 0};
        int var12 = -var7;
        int var13 = -var7;

        label32:
        for (placePos[majorAxis] = genPos[majorAxis]; var12 <= var7; ++var12) {
            placePos[var8] = genPos[var8] + var12;
            var13 = -var7;

            while (true) {
                if (var13 > var7) {
                    continue label32;
                }

                double var15 = Math.sqrt(Math.pow((double) Math.abs(var12) + 0.5, 2.0) + Math.pow((double) Math.abs(var13) + 0.5, 2.0));
                if (!(var15 > (double) shape)) {
                    placePos[var9] = genPos[var9] + var13;
                    int placePosBlockId = this.world.getBlockId(placePos[0], placePos[1], placePos[2]);
                    if (placePosBlockId == 0 || placePosBlockId == 18) {
                        if (random.nextInt(20) == 0 && airBlocksAround(x,y,z,world) > 2) {
                            this.world.setBlockWithoutNotifyingNeighbors(placePos[0], placePos[1], placePos[2], Block.COBWEB.id);
                        } else {
                            this.world.setBlockWithoutNotifyingNeighbors(placePos[0], placePos[1], placePos[2], clusterBlock);
                        }

                    }
                }
                var13++;
            }
        }
    }

    @Override
    public void placeFoliageCluster(int x, int baseY, int z) {
        int var4 = baseY;

        for(int var5 = baseY + this.foliageClusterHeight; var4 < var5; ++var4) {
            float var6 = this.getClusterShape(var4 - baseY);
            this.placeCluster(x, var4, z, var6, (byte)1, BlockListener.swampLeaves.id);
        }

    }

    @Override
    public void PlaceTrunk() {
        int var1 = this.origin[0];
        int var2 = this.origin[1];
        int var3 = this.origin[1] + this.trunkHeight;
        int var4 = this.origin[2];
        int[] var5 = new int[]{var1, var2, var4};
        int[] var6 = new int[]{var1, var3, var4};
        this.placeBranch(var5, var6, BlockListener.swampLog.id);
        if (this.trunkWidth == 2) {
            int var10002 = var5[0]++;
            var10002 = var6[0]++;
            this.placeBranch(var5, var6, BlockListener.swampLog.id);
            var10002 = var5[2]++;
            var10002 = var6[2]++;
            this.placeBranch(var5, var6, BlockListener.swampLog.id);
            var5[0] += -1;
            var6[0] += -1;
            this.placeBranch(var5, var6, BlockListener.swampLog.id);
        }

    }

    @Override
    public void placeBranches() {
        int var1 = 0;
        int var2 = this.branches.length;

        for(int[] var3 = new int[]{this.origin[0], this.origin[1], this.origin[2]}; var1 < var2; ++var1) {
            int[] var4 = this.branches[var1];
            int[] var5 = new int[]{var4[0], var4[1], var4[2]};
            var3[1] = var4[3];
            int var6 = var3[1] - this.origin[1];
            if (this.shouldPlaceBranch(var6)) {
                this.placeBranch(var3, var5, BlockListener.swampLog.id);
            }
        }

    }

    public int airBlocksAround(int x, int y, int z, World world) {
        int airBlocks = 0;

        for (var dir : Direction.values()) {
            if (world.getBlockState(x + dir.getOffsetX(), y + dir.getOffsetY(), z + dir.getOffsetZ()).isAir()) {
                airBlocks++;
            }
        }

        return airBlocks;
    }
}