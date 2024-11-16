package com.beefyandtheducks.moreblockvariations.datagen;

import com.beefyandtheducks.moreblockvariations.BlockVariations;
import com.beefyandtheducks.moreblockvariations.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, by default it is en_us.
        super(dataGenerator, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.ITEM_GROUP_KEY, "More Blocks");

        for (BlockVariations blkVar : ModBlocks.REGISTERED_BLOCKS)
            generateTranslationsFor(translationBuilder, blkVar);
    }

    private static void generateTranslationsFor(TranslationBuilder translationBuilder, BlockVariations blockVariations) {
        final String blockName = blockVariations.getOriginal().getName().getString();

        translationBuilder.add(blockVariations.getVerticalSlab(), blockName + " Vertical Slab");
        translationBuilder.add(blockVariations.getVerticalStair(), blockName + " Vertical Stair");
        translationBuilder.add(blockVariations.getCorner(), blockName + " Corner");
    }
}
