package net.erzekawek.enditions.registries;

import net.erzekawek.enditions.Enditions;
import net.erzekawek.enditions.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.betterx.bclib.config.PathConfig;
import org.betterx.bclib.registry.BlockRegistry;
import org.betterx.worlds.together.tag.v3.TagManager;
import org.jetbrains.annotations.NotNull;


public class EnditionBlocks {
    public static final BlockRegistry REGISTRY = new BlockRegistry(new PathConfig(Enditions.MOD_ID, "blocks"));
    public static final Block XLORIS_ENDLYUM = register(
            "xloris_endlyum",
            new XlorisEndlyumBlock(),
            BlockTags.NYLIUM
    );

    private static Block register(String name, Block block) {
        return REGISTRY.register(Enditions.makeID(name), block);
    }

    public static Block registerBlock(ResourceLocation id, Block block, TagKey<Block>... tags) {
//		Sometimes maybe
//		if (!Configs.BLOCK_CONFIG.getBooleanRoot(id.getPath(), true)) {
//			return block;
//		}
        getBlockRegistry().register(id, block);
        TagManager.BLOCKS.add(block, tags);
        return block;
    }

    private static Block register(String name, Block block,  TagKey<Block>... tags) {
        return registerBlock(Enditions.makeID(name), block, tags);
    }

    private static Block registerBlockOnly(String name, Block block) {
        return REGISTRY.registerBlockOnly(Enditions.makeID(name), block);
    }

    public static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    @NotNull
    public static BlockRegistry getBlockRegistry() {
        return REGISTRY;
    }

}
