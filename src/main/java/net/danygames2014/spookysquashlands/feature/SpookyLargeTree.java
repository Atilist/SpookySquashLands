package net.danygames2014.spookysquashlands.feature;

import net.minecraft.world.gen.feature.LargeOakTreeFeature;

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
}
