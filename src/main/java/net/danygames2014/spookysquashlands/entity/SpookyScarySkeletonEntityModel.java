package net.danygames2014.spookysquashlands.entity;

import net.minecraft.client.render.entity.model.SkeletonEntityModel;
import net.minecraft.util.math.MathHelper;

public class SpookyScarySkeletonEntityModel extends SkeletonEntityModel {
    public SpookyScarySkeletonEntityModel() {
        this.rightArm.pitch = 0.0F;
        this.leftArm.pitch = 0.0F;
    }

    @Override
    public void setAngles(float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch, float scale) {
        super.setAngles(limbAngle, limbDistance, animationProgress, headYaw, headPitch, scale);
        this.rightArm.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 2.0F * limbDistance * 0.5F;
        this.leftArm.pitch = MathHelper.cos(limbAngle * 0.6662F) * 2.0F * limbDistance * 0.5F;
    }
}
