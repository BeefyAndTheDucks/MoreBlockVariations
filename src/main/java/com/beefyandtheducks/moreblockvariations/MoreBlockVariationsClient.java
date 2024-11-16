package com.beefyandtheducks.moreblockvariations;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;

public class MoreBlockVariationsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MoreBlockVariations.LOGGER.info("Running " + MoreBlockVariations.MOD_NAME + " on the client!");

        // To make some parts of the block transparent (like glass, saplings and doors):
        makeVariantsTransparent(Blocks.GLASS);
        makeVariantsTransparent(Blocks.TINTED_GLASS);

        makeVariantsTransparent(Blocks.WHITE_STAINED_GLASS);
        makeVariantsTransparent(Blocks.ORANGE_STAINED_GLASS);
        makeVariantsTransparent(Blocks.MAGENTA_STAINED_GLASS);
        makeVariantsTransparent(Blocks.LIGHT_BLUE_STAINED_GLASS);
        makeVariantsTransparent(Blocks.YELLOW_STAINED_GLASS);
        makeVariantsTransparent(Blocks.LIME_STAINED_GLASS);
        makeVariantsTransparent(Blocks.PINK_STAINED_GLASS);
        makeVariantsTransparent(Blocks.GRAY_STAINED_GLASS);
        makeVariantsTransparent(Blocks.LIGHT_GRAY_STAINED_GLASS);
        makeVariantsTransparent(Blocks.CYAN_STAINED_GLASS);
        makeVariantsTransparent(Blocks.PURPLE_STAINED_GLASS);
        makeVariantsTransparent(Blocks.BLUE_STAINED_GLASS);
        makeVariantsTransparent(Blocks.BROWN_STAINED_GLASS);
        makeVariantsTransparent(Blocks.GREEN_STAINED_GLASS);
        makeVariantsTransparent(Blocks.RED_STAINED_GLASS);
        makeVariantsTransparent(Blocks.BLACK_STAINED_GLASS);

        makeVariantsTransparent(Blocks.ICE);
        makeVariantsTransparent(Blocks.PACKED_ICE);
        makeVariantsTransparent(Blocks.BLUE_ICE);
    }

    private static void makeVariantsTransparent(Block original) {
        BlockVariations block = ModBlocks.BLOCK_TO_REGISTERED.get(original);
        BlockRenderLayerMap.INSTANCE.putBlock(block.getVerticalSlab(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(block.getVerticalStair(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(block.getCorner(), RenderLayer.getCutout());
    }
}
