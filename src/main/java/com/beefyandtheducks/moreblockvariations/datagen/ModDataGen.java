package com.beefyandtheducks.moreblockvariations.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModEnglishLangProvider::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModBlockLootTables::new);
    }
}
