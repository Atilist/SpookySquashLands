package net.danygames2014.spookysquashlands.entity;

import net.danygames2014.spookysquashlands.SpookySquashLands;
import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.server.entity.HasTrackingParameters;
import net.modificationstation.stationapi.api.server.entity.MobSpawnDataProvider;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.TriState;

@HasTrackingParameters(updatePeriod = 2, sendVelocity = TriState.TRUE, trackingDistance = 50)
public class SpookyScarySkeletonEntity extends MonsterEntity implements MobSpawnDataProvider {
    public ItemStack heldItem;
    
    public SpookyScarySkeletonEntity(World world) {
        super(world);
        heldItem = null;
        this.texture = "/mob/skeleton.png";
        this.attackDamage = 1;
    }

    public SpookyScarySkeletonEntity(World world, Double x, Double y, Double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    public void tickMovement() {
//        if (this.world.canMonsterSpawn()) {
//            float var1 = this.getBrightnessAtEyes(1.0F);
//            if (var1 > 0.5F && this.world.hasSkyLight(MathHelper.floor(this.x), MathHelper.floor(this.y), MathHelper.floor(this.z)) && this.random.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
//                this.fireTicks = 300;
//            }
//        }

        super.tickMovement();
    }
    
    protected String getRandomSound() {
        return "mob.skeleton";
    }

    protected String getHurtSound() {
        return "mob.skeletonhurt";
    }

    protected String getDeathSound() {
        return "mob.skeletonhurt";
    }

    protected int getDroppedItemId() {
        return Item.BONE.id;
    }

    protected void dropItems() {
        for(int i = 0; i < random.nextInt(3); ++i) {
            this.dropItem(Item.BONE.id, 1);
        }
    }

    @Override
    public ItemStack getHeldItem() {
        return heldItem;
    }

    @Override
    public Identifier getHandlerIdentifier() {
        return SpookySquashLands.NAMESPACE.id("spooky_scary_skeleton");
    }
}
