package net.tgh245.valyken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.tgh245.valyken.block.ModBlocks;
import net.tgh245.valyken.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ALEXANDRITE_TABLE = List.of(ModItems.RAW_ALEXANDRITE.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                    .define('A', ModItems.ALEXANDRITE.get())
                        .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModItems.ALEXANDRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                    .define('A', ModItems.RAW_ALEXANDRITE.get())
                        .unlockedBy(getHasName(ModItems.RAW_ALEXANDRITE.get()), has(ModItems.RAW_ALEXANDRITE.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), 9)
                        .requires(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                                .unlockedBy(getHasName(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), has(ModItems.RAW_ALEXANDRITE.get()))
                .save(pRecipeOutput);

        oreBlasting(pRecipeOutput,ALEXANDRITE_TABLE, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.5f, 100, "alexandrite");
        oreSmelting(pRecipeOutput,ALEXANDRITE_TABLE, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.5f, 100, "alexandrite");
    }
}
