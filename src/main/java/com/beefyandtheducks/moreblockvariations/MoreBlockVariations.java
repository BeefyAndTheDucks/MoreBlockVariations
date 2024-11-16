package com.beefyandtheducks.moreblockvariations;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBlockVariations implements ModInitializer {

    public static final String MOD_ID = "moreblockvariations";
    public static final String MOD_NAME = "More Block Variations";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        MoreBlockVariations.LOGGER.info("Running " + MoreBlockVariations.MOD_NAME + " on the server!");

        ModBlocks.init();
    }
}
