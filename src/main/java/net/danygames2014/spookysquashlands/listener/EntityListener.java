package net.danygames2014.spookysquashlands.listener;

import net.danygames2014.spookysquashlands.SpookySquashLands;
import net.danygames2014.spookysquashlands.entity.SpookyScarySkeletonEntity;
import net.danygames2014.spookysquashlands.entity.SpookyScarySkeletonEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.UndeadEntityRenderer;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;
import net.modificationstation.stationapi.api.event.entity.EntityRegister;
import net.modificationstation.stationapi.api.event.registry.MobHandlerRegistryEvent;
import net.modificationstation.stationapi.api.registry.Registry;

public class EntityListener {
    @EventListener
    public void registerEntities(EntityRegister event) {
        event.register(SpookyScarySkeletonEntity.class, "spooky_scary_skeleton");
    }
    
    @EventListener
    public void registerMobHandlers(MobHandlerRegistryEvent event) {
        Registry.register(event.registry, SpookySquashLands.NAMESPACE.id("spooky_scary_skeleton"), SpookyScarySkeletonEntity::new);
    }

    @Environment(EnvType.CLIENT)
    @EventListener
    public void registerEntityRenderer(EntityRendererRegisterEvent event) {
        event.renderers.put(SpookyScarySkeletonEntity.class, new UndeadEntityRenderer(new SpookyScarySkeletonEntityModel(), 0.5F));
    }
}
