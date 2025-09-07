package net.vertaloxi.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.vertaloxi.tutorialmod.block.ModBlocks;
import net.vertaloxi.tutorialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LEGENDARY_DIAMOND, RecipeCategory.DECORATIONS, ModBlocks.LEGENDARY_DIAMOND_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" U ")
                .input('R', ModItems.LEGENDARY_DIAMOND)
                .input('U', Items.STICK)
                .criterion(hasItem(ModItems.LEGENDARY_DIAMOND), conditionsFromItem(ModItems.LEGENDARY_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("WWW")
                .pattern("WRW")
                .pattern("WWW")
                .input('W', ModItems.LEGENDARY_DIAMOND)
                .input('R', ModItems.SHY_GOLDEN_APPLE)
                .criterion(hasItem(ModItems.LEGENDARY_DIAMOND), conditionsFromItem(ModItems.LEGENDARY_DIAMOND))
                .criterion(hasItem(ModItems.SHY_GOLDEN_APPLE), conditionsFromItem(ModItems.SHY_GOLDEN_APPLE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("  L")
                .pattern(" S ")
                .pattern("S  ")
                .input('L', ModItems.LEGENDARY_DIAMOND)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.LEGENDARY_DIAMOND), conditionsFromItem(ModItems.LEGENDARY_DIAMOND))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SHY_GOLDEN_APPLE_BLOCK)
                .pattern("RR")
                .pattern("RR")
                .input('R', ModItems.SHY_GOLDEN_APPLE)
                .criterion(hasItem(ModItems.SHY_GOLDEN_APPLE), conditionsFromItem(ModItems.SHY_GOLDEN_APPLE))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHY_GOLDEN_APPLE, 4)
                .input(ModBlocks.SHY_GOLDEN_APPLE_BLOCK)
                .criterion(hasItem(ModItems.SHY_GOLDEN_APPLE), conditionsFromItem(ModItems.SHY_GOLDEN_APPLE))
                .offerTo(recipeExporter);
    }
}
