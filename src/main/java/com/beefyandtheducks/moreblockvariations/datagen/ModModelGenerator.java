package com.beefyandtheducks.moreblockvariations.datagen;

import com.beefyandtheducks.moreblockvariations.BlockVariations;
import com.beefyandtheducks.moreblockvariations.ModBlocks;
import com.beefyandtheducks.moreblockvariations.MoreBlockVariations;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (BlockVariations blkVar : ModBlocks.REGISTERED_BLOCKS)
            genDataFor(blockStateModelGenerator, blkVar);
    }

    private static void genDataFor(BlockStateModelGenerator blockStateModelGenerator, BlockVariations blockVariations) {
        registerVerticalSlab(blockStateModelGenerator, blockVariations.getVerticalSlab(), blockVariations.getOriginal());
        registerVerticalStair(blockStateModelGenerator, blockVariations.getVerticalStair(), blockVariations.getOriginal());
        registerCorner(blockStateModelGenerator, blockVariations.getCorner(), blockVariations.getOriginal());
    }

    private static void registerBlockState(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        final Identifier blockId = Registries.BLOCK.getId(block);

        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(block)
                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.NORTH),
                        BlockStateVariant.union(
                                BlockStateVariant.union(BlockStateVariant.create().put(
                                                VariantSettings.Y, VariantSettings.Rotation.R180),
                                        BlockStateVariant.create().put(VariantSettings.UVLOCK, true)),
                                BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MoreBlockVariations.MOD_ID, "block/" + blockId.getPath()))))

                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.EAST),
                        BlockStateVariant.union(
                                BlockStateVariant.union(BlockStateVariant.create().put(
                                                VariantSettings.Y, VariantSettings.Rotation.R270),
                                        BlockStateVariant.create().put(VariantSettings.UVLOCK, true)),
                                BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MoreBlockVariations.MOD_ID, "block/" + blockId.getPath()))))

                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.SOUTH),
                        BlockStateVariant.union(
                                BlockStateVariant.union(BlockStateVariant.create().put(
                                                VariantSettings.Y, VariantSettings.Rotation.R0),
                                        BlockStateVariant.create().put(VariantSettings.UVLOCK, true)),
                                BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MoreBlockVariations.MOD_ID, "block/" + blockId.getPath()))))

                .with(When.create().set(Properties.HORIZONTAL_FACING, Direction.WEST),
                        BlockStateVariant.union(
                                BlockStateVariant.union(BlockStateVariant.create().put(
                                                VariantSettings.Y, VariantSettings.Rotation.R90),
                                        BlockStateVariant.create().put(VariantSettings.UVLOCK, true)),
                                BlockStateVariant.create().put(VariantSettings.MODEL, Identifier.of(MoreBlockVariations.MOD_ID, "block/" + blockId.getPath()))))
        );
    }

    private static void registerModel(BlockStateModelGenerator blockStateModelGenerator, Block block, Block originalBlock, Identifier parentId) {
        final Identifier blockId = Registries.BLOCK.getId(block);
        final Identifier originalBlockId = Registries.BLOCK.getId(originalBlock);

        blockStateModelGenerator.modelCollector.accept(Identifier.of(MoreBlockVariations.MOD_ID, "block/" + blockId.getPath()), () -> {
            JsonObject textureData = new JsonObject();
            textureData.addProperty("bottom", "block/" + originalBlockId.getPath());
            textureData.addProperty("top", "block/" + originalBlockId.getPath());
            textureData.addProperty("side", "block/" + originalBlockId.getPath());

            JsonObject modelData = new JsonObject();
            modelData.addProperty("parent", parentId.toString());
            modelData.add("textures", textureData);

            return modelData;
        });
    }

    private static void registerVerticalStair(BlockStateModelGenerator blockStateModelGenerator, Block block, Block originalBlock) {
        registerBlockState(blockStateModelGenerator, block);
        registerModel(blockStateModelGenerator, block, originalBlock, Identifier.of("moreblockvariations", "block/vertical_stair"));
    }

    private static void registerVerticalSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Block originalBlock) {
        registerBlockState(blockStateModelGenerator, block);
        registerModel(blockStateModelGenerator, block, originalBlock, Identifier.of("moreblockvariations", "block/vertical_slab"));
    }

    private static void registerCorner(BlockStateModelGenerator blockStateModelGenerator, Block block, Block originalBlock) {
        registerBlockState(blockStateModelGenerator, block);
        registerModel(blockStateModelGenerator, block, originalBlock, Identifier.of("moreblockvariations", "block/corner"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // NO-OP
    }
}
