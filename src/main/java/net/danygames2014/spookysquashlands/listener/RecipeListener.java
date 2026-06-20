package net.danygames2014.spookysquashlands.listener;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;
import net.modificationstation.stationapi.api.util.Identifier;

public class RecipeListener {
    private boolean addedRecipes = false;

    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        Identifier type = event.recipeId;
        if (addedRecipes) {
            return;
        }
        addedRecipes = true;
        SmeltingRegistry.addSmeltingRecipe(BlockListener.solidIce.asItem().id, new ItemStack(Block.ICE));
        SmeltingRegistry.addSmeltingRecipe(BlockListener.plainsLog.asItem().id, new ItemStack(Item.COAL, 1, 1));
        SmeltingRegistry.addSmeltingRecipe(BlockListener.swampLog.asItem().id, new ItemStack(Item.COAL, 1, 1));
        SmeltingRegistry.addSmeltingRecipe(BlockListener.jungleLog.asItem().id, new ItemStack(Item.COAL, 1, 1));

        CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.junglePlanks, 4), new ItemStack(BlockListener.jungleLog));
        CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.swampPlanks, 4), new ItemStack(BlockListener.swampLog));
        CraftingRegistry.addShapelessRecipe(new ItemStack(BlockListener.plainsPlanks, 4), new ItemStack(BlockListener.plainsLog));

        CraftingRegistry.addShapedRecipe(new ItemStack(ItemListener.swampAxe, 1), "ZX", "YX", "Y ", 'X', new ItemStack(BlockListener.swampPlanks), 'Y', new ItemStack(Item.STICK), 'Z', new ItemStack(Item.IRON_INGOT));
    }
}
