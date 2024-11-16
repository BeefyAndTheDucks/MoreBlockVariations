package com.beefyandtheducks.moreblockvariations.datagen;

import com.beefyandtheducks.moreblockvariations.BlockVariations;
import com.beefyandtheducks.moreblockvariations.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTables extends FabricBlockLootTableProvider{
    public ModBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        for (BlockVariations block : ModBlocks.REGISTERED_BLOCKS) {
            generateFor(block);
        }
    }

    private void generateFor(BlockVariations block) {
        generateSelfDrop(block.getVerticalSlab());
        generateSelfDrop(block.getVerticalStair());
        generateSelfDrop(block.getCorner());
    }

    private void generateSelfDrop(Block block) {
        addDrop(block, drops(block));
    }
}
