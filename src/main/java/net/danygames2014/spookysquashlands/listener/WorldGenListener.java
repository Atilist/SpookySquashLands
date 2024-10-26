package net.danygames2014.spookysquashlands.listener;

import net.danygames2014.spookysquashlands.entity.SpookyScarySkeletonEntity;
import net.danygames2014.spookysquashlands.feature.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeProviderRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.BiomeAPI;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;
import net.modificationstation.stationapi.api.worldgen.biome.ClimateBiomeProvider;
import net.modificationstation.stationapi.api.worldgen.feature.HeightScatterFeature;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceBuilder;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceRule;

public class WorldGenListener {
    private Biome[] spookyBiomes;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {
        spookyBiomes = new Biome[4];

        // Spooky Tundra
        SurfaceRule tundraSurface = SurfaceBuilder.start(BlockListener.solidIce).replace(Block.GRASS_BLOCK).build();
        SurfaceRule tundraFilling = SurfaceBuilder.start(BlockListener.solidIce).replace(Block.STONE).build();

        BiomeBuilder spookyBuilder;
        spookyBuilder = BiomeBuilder.start("Spooky Tundra");
        spookyBuilder.height(48, 128);
        spookyBuilder.snow(true);
        spookyBuilder.leavesColor(0xFF3A976D);
        spookyBuilder.grassColor(0xFF3A976D);
        spookyBuilder.fogColor(0xFFFFFFFF);
        spookyBuilder.surfaceRule(tundraSurface);
        spookyBuilder.surfaceRule(tundraFilling);
        spookyBuilder.feature(new HeightScatterFeature(new GlacierFeature(), 1));
        spookyBuilder.feature(new HeightScatterFeature(new FrozenPumpkinFeature(), 1));
        spookyBiomes[0] = spookyBuilder.build();

        // Spooky Plains
        spookyBuilder = BiomeBuilder.start("Spooky Plains");
        spookyBuilder.height(48, 128);
        spookyBuilder.leavesColor(0xFFBEBA30);
        spookyBuilder.grassColor(0xFFBEBA30);
        spookyBuilder.fogColor(0xFFFFFFFF);
        spookyBuilder.feature(new HeightScatterFeature(new GiantPumpkinFeature(), 1));
        spookyBuilder.feature(new HeightScatterFeature(new LonelyOakTreeFeature(), 1));
        spookyBuilder.feature(new HeightScatterFeature(new BushFeature(), 1));
        spookyBiomes[1] = spookyBuilder.build();

        // Spooky Forest
        spookyBuilder = BiomeBuilder.start("Spooky Forest");
        spookyBuilder.height(48, 80);
        spookyBuilder.leavesColor(0xFF353735);
        spookyBuilder.grassColor(0xFF353735);
        spookyBuilder.fogColor(0xFF202020);
        spookyBuilder.noDimensionFeatures();
        spookyBuilder.overworldOres();
        spookyBuilder.hostileEntity(SpookyScarySkeletonEntity.class, 5);
        spookyBuilder.feature(new HeightScatterFeature(new SpookyLargeTree(), 2));
        spookyBuilder.feature(new HeightScatterFeature(new SpikyBushFeature(), 2));
        spookyBuilder.feature(new GrassFeature(0, 16));
        spookyBuilder.feature(new GrassFeature(1, 128));
        spookyBuilder.feature(new HeightScatterFeature(new SpikePumpkinFeature(), 1));
        spookyBiomes[2] = spookyBuilder.build();

        // Spooky Jungle
        spookyBuilder = BiomeBuilder.start("Spooky Jungle");
        spookyBuilder.height(48, 128);
        spookyBuilder.leavesColor(0xFF3A9719);
        spookyBuilder.grassColor(0xFF3A9719);
        spookyBuilder.fogColor(0xFFFFFFFF);
        spookyBuilder.feature(new HeightScatterFeature(new JungleTreeFeature(), 2));
        spookyBuilder.feature(new HeightScatterFeature(new JunglePumpkinFeature(), 1));
        spookyBiomes[3] = spookyBuilder.build();
    }

    // This method has been unlobotomized for sanity purposes
    @EventListener
    public void registerRegions(BiomeProviderRegisterEvent event) {
        // Simple climate provider with biomes by temperature
        ClimateBiomeProvider provider = new ClimateBiomeProvider();
        provider.addBiome(spookyBiomes[0], 0.0F, 0.4F, 0, 1);
        provider.addBiome(spookyBiomes[1], 0.4F, 0.75F, 0, 1);
        provider.addBiome(spookyBiomes[2], 0.75F, 0.95F, 0, 1);
        provider.addBiome(spookyBiomes[3], 0.95F, 1.0F, 0, 1);

        BiomeAPI.addOverworldBiomeProvider(StationAPI.NAMESPACE.id("spooky_provider"), provider);
    }
}
