package net.erzekawek.enditions;

import net.erzekawek.enditions.registries.EnditionBlocks;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.betterx.bclib.creativetab.BCLCreativeTabManager;
import org.betterx.bclib.registry.BaseRegistry;
import org.betterx.worlds.together.world.WorldConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Enditions implements ModInitializer {
    public static final String MOD_ID = "enditions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        WorldConfig.registerModCache(MOD_ID); //idk
        BCLCreativeTabManager.create(MOD_ID)
                .createTab("eden_tab")
                .setPredicate(
                        item -> BaseRegistry.getModBlockItems(MOD_ID).contains(item)
                                || BaseRegistry.getModItems(MOD_ID).contains(item)
                )
                .setIcon(EnditionBlocks.XLORIS_ENDLYUM)
                .build()
                .processBCLRegistry()
                .register();
    }

    public static ResourceLocation makeID(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}