package net.danygames2014.spookysquashlands.listener;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.BirchTreeFeature;
import net.minecraft.world.gen.feature.LargeOakTreeFeature;
import net.minecraft.world.gen.feature.PumpkinPatchFeature;
import net.modificationstation.stationapi.api.StationAPI;
import net.modificationstation.stationapi.api.event.world.biome.BiomeRegisterEvent;
import net.modificationstation.stationapi.api.event.worldgen.biome.BiomeProviderRegisterEvent;
import net.modificationstation.stationapi.api.worldgen.BiomeAPI;
import net.modificationstation.stationapi.api.worldgen.biome.BiomeBuilder;
import net.modificationstation.stationapi.api.worldgen.biome.ClimateBiomeProvider;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceBuilder;
import net.modificationstation.stationapi.api.worldgen.surface.SurfaceRule;

public class WorldGenListener {
    private Biome[] spookyBiomes;

    @EventListener
    public void registerBiomes(BiomeRegisterEvent event) {

        spookyBiomes = new Biome[4];

        // Spooky Tundra
        SurfaceRule tundraSurface = SurfaceBuilder.start(Block.SNOW_BLOCK).replace(Block.GRASS_BLOCK).build();

        BiomeBuilder spookyBuilder = BiomeBuilder.start("Spooky Tundra");
        spookyBuilder.height(64, 128);
        spookyBuilder.snow(true);
        spookyBuilder.leavesColor(0xFF004444);
        spookyBuilder.grassColor(0xFF004444);
        spookyBuilder.fogColor(0xFF334444);
        spookyBuilder.surfaceRule(tundraSurface);
        spookyBiomes[0] = spookyBuilder.build();

        // Spooky Plains
        spookyBuilder = BiomeBuilder.start("Spooky Plains");
        spookyBuilder.height(64, 128);
        spookyBuilder.leavesColor(0xFF004400);
        spookyBuilder.grassColor(0xFF004400);
        spookyBuilder.fogColor(0xFF334433);
        spookyBuilder.feature(new PumpkinPatchFeature());
        spookyBiomes[1] = spookyBuilder.build();

        // Spooky Forest
        spookyBuilder = BiomeBuilder.start("Spooky Forest");
        spookyBuilder.height(64, 128);
        spookyBuilder.leavesColor(0xFF226600);
        spookyBuilder.grassColor(0xFF226600);
        spookyBuilder.fogColor(0xFF556633);
        spookyBuilder.feature(new BirchTreeFeature());
        spookyBiomes[2] = spookyBuilder.build();

        // Spooky Jungle
        spookyBuilder = BiomeBuilder.start("Spooky Jungle");
        spookyBuilder.height(64, 128);
        spookyBuilder.leavesColor(0xFF00AA00);
        spookyBuilder.grassColor(0xFF00AA00);
        spookyBuilder.fogColor(0xFF33AA33);
        spookyBuilder.feature(new LargeOakTreeFeature());
        spookyBiomes[3] = spookyBuilder.build();
    }

    @EventListener
    public void registerRegions(BiomeProviderRegisterEvent event) {
        // Simple climate provider with biomes by temperature
        ClimateBiomeProvider provider = new ClimateBiomeProvider();
        provider.addBiome(spookyBiomes[0], 0, 0.35F, 0, 1);
        provider.addBiome(spookyBiomes[1], 0.35F, 0.8F, 0, 1);
        provider.addBiome(spookyBiomes[2], 0.8F, 0.95F, 0, 1);
        provider.addBiome(spookyBiomes[3], 0.95F, 1, 0, 1);
        BiomeAPI.addOverworldBiomeProvider(StationAPI.NAMESPACE.id("spooky_provider"), provider);
    }
}
