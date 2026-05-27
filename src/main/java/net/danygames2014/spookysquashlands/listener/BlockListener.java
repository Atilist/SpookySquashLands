package net.danygames2014.spookysquashlands.listener;

import net.danygames2014.spookysquashlands.block.*;
import net.danygames2014.spookysquashlands.feature.JungleTreeFeature;
import net.danygames2014.spookysquashlands.feature.LonelyOakTreeFeature;
import net.danygames2014.spookysquashlands.feature.SpookyLargeTree;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static Block giantPumpkinTop;
    public static Block giantPumpkinMiddle;
    public static Block giantPumpkinBottom;

    public static Block spikePumpkin;

    public static Block solidIce;

    public static Block frozenPumpkin;

    public static Block junglePumpkin;

    public static LazyBlockTemplate jungleLog, swampLog, plainsLog;
    public static LazyLeavesTemplate jungleLeaves, swampLeaves, plainsLeaves;
    public static LazyBlockTemplate junglePlanks, swampPlanks, plainsPlanks;
    public static LazySaplingTemplate jungleSapling, swampSapling, plainsSapling;

    @Entrypoint.Namespace
    public static Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        giantPumpkinTop = new GiantPumpkinTopBlock(Identifier.of(NAMESPACE, "giant_pumpkin_top"), Material.PUMPKIN).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        giantPumpkinMiddle = new GiantPumpkinMiddleBlock(Identifier.of(NAMESPACE, "giant_pumpkin_middle"), Material.PUMPKIN).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        giantPumpkinBottom = new GiantPumpkinBottomBlock(Identifier.of(NAMESPACE, "giant_pumpkin_bottom"), Material.PUMPKIN).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        plainsLog = new LazyBlockTemplate(Identifier.of(NAMESPACE, "plains_log"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        plainsLeaves = new LazyLeavesTemplate(Identifier.of(NAMESPACE, "plains_leaves"), Material.LEAVES, 1.0F, Block.DIRT_SOUND_GROUP);
        plainsPlanks = new LazyBlockTemplate(Identifier.of(NAMESPACE, "plains_planks"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        plainsSapling = new LazySaplingTemplate(Identifier.of(NAMESPACE, "plains_sapling"), Material.PLANT, 0, Block.DIRT_SOUND_GROUP, new LonelyOakTreeFeature());

        spikePumpkin = new SpikePumpkinBlock(Identifier.of(NAMESPACE, "spike_pumpkin"), Material.PUMPKIN).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        swampLog = new LazyBlockTemplate(Identifier.of(NAMESPACE, "swamp_log"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        swampLeaves = new LazyLeavesTemplate(Identifier.of(NAMESPACE, "swamp_leaves"), Material.LEAVES, 1.0F, Block.DIRT_SOUND_GROUP);
        swampPlanks = new LazyBlockTemplate(Identifier.of(NAMESPACE, "swamp_planks"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        swampSapling = new LazySaplingTemplate(Identifier.of(NAMESPACE, "swamp_sapling"), Material.PLANT, 0, Block.DIRT_SOUND_GROUP, new SpookyLargeTree());

        solidIce = new SolidIceBlock(Identifier.of(NAMESPACE, "solid_ice"), Material.STONE).setHardness(1.5F).setSoundGroup(Block.GLASS_SOUND_GROUP);
        frozenPumpkin = new FrozenPumpkinBlock(Identifier.of(NAMESPACE, "frozen_pumpkin"), Material.PUMPKIN).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);

        junglePumpkin = new JunglePumpkinBlock(Identifier.of(NAMESPACE, "jungle_pumpkin"), Material.PUMPKIN).setHardness(1.5F).setSoundGroup(Block.WOOD_SOUND_GROUP);
        jungleLog = new LazyBlockTemplate(Identifier.of(NAMESPACE, "jungle_log"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        jungleLeaves = new LazyLeavesTemplate(Identifier.of(NAMESPACE, "jungle_leaves"), Material.LEAVES, 1.0F, Block.DIRT_SOUND_GROUP);
        junglePlanks = new LazyBlockTemplate(Identifier.of(NAMESPACE, "jungle_planks"), Material.WOOD, 1.5F, Block.WOOD_SOUND_GROUP);
        jungleSapling = new LazySaplingTemplate(Identifier.of(NAMESPACE, "jungle_sapling"), Material.PLANT, 0, Block.DIRT_SOUND_GROUP, new JungleTreeFeature());

        // Add block parameters
        plainsLeaves.setLogBlock(plainsLog);
        plainsLeaves.setSaplingBlock(plainsSapling);

        swampLeaves.setLogBlock(swampLog);
        swampLeaves.setSaplingBlock(swampSapling);

        jungleLeaves.setLogBlock(jungleLog);
        jungleLeaves.setSaplingBlock(jungleSapling);
    }
}
