package com.beefyandtheducks.moreblockvariations;

import net.minecraft.block.Block;

public class BlockVariations {

    private final Block ORIGINAL;
    private final Block VERTICAL_SLAB;
    private final Block VERTICAL_STAIR;
    private final Block CORNER;

    public BlockVariations(Block original, Block verticalSlab, Block verticalStair, Block corner) {
        ORIGINAL = original;
        VERTICAL_SLAB = verticalSlab;
        VERTICAL_STAIR = verticalStair;
        CORNER = corner;
    }

    public Block getOriginal() {
        return ORIGINAL;
    }

    public Block getVerticalSlab() {
        return VERTICAL_SLAB;
    }

    public Block getVerticalStair() {
        return VERTICAL_STAIR;
    }

    public Block getCorner() {
        return CORNER;
    }
}
