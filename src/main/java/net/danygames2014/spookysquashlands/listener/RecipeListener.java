package net.danygames2014.spookysquashlands.listener;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

public class RecipeListener {
    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;
        if (type == RecipeRegisterEvent.Vanilla.SMELTING.type()) {
            SmeltingRegistry.addSmeltingRecipe(BlockListener.solidIce.asItem().id, new ItemStack(Block.ICE));
        }
        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS.type()) {
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.junglePlanks, 4), new ItemStack(BlockListener.jungleLog));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.swampPlanks, 4), new ItemStack(BlockListener.swampLog));
            CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.plainsPlanks, 4), new ItemStack(BlockListener.plainsLog));
        }
    }
}
