package com.beefyandtheducks.moreblockvariations.datagen;

import com.beefyandtheducks.moreblockvariations.BlockVariations;
import com.beefyandtheducks.moreblockvariations.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                for (BlockVariations block : ModBlocks.REGISTERED_BLOCKS)
                    generateRecipesFor(block);
            }

            private void generateRecipesFor(BlockVariations blockVariations) {
                createRecipe(blockVariations.getVerticalSlab(), blockVariations.getOriginal(), 6,
                        "  b",
                        "  b",
                        "  b");
                createRecipe(blockVariations.getVerticalStair(), blockVariations.getOriginal(), 8,
                        "bbb",
                        " bb",
                        "  b");
                createRecipe(blockVariations.getCorner(), blockVariations.getOriginal(), 8,
                        "   ",
                        "  b",
                        "  b");
            }

            private void createRecipe(ItemConvertible output, ItemConvertible ingredient, int count, String row1, String row2, String row3) {
                createShaped(RecipeCategory.DECORATIONS, output, count)
                        .pattern(row1)
                        .pattern(row2)
                        .pattern(row3)
                        .input('b', ingredient)
                        .criterion(hasItem(ingredient),
                                conditionsFromItem(ingredient))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
