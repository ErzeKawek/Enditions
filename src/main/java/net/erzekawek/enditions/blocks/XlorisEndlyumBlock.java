package net.erzekawek.enditions.blocks;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.betterx.bclib.client.models.ModelsHelper;
import org.betterx.bclib.client.models.PatternsHelper;
import org.betterx.bclib.client.render.BCLRenderLayer;
import org.betterx.bclib.interfaces.BlockModelProvider;
import org.betterx.bclib.interfaces.CustomColorProvider;
import org.betterx.bclib.interfaces.RenderLayerProvider;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class XlorisEndlyumBlock extends GrassBlock implements BlockModelProvider, RenderLayerProvider {
    public XlorisEndlyumBlock() {
        super(FabricBlockSettings.copyOf(Blocks.END_STONE));
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        ItemStack tool = builder.getParameter(LootContextParams.TOOL);
        if (tool == null || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) == 0) {
            return Collections.singletonList(new ItemStack(Blocks.END_STONE));
        }
        return Collections.singletonList(new ItemStack(this));
    }
    @Override
    public BlockModel getItemModel(ResourceLocation blockId) {
        return this.getBlockModel(blockId, this.defaultBlockState());
    }
    @Override
    @Environment(EnvType.CLIENT)
    public BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
        String modId = blockId.getNamespace();
        Map<String, String> textures = Maps.newHashMap();
        textures.put("%top%", modId + ":block/xloris_endlyum_top");
        textures.put("%side%", modId + ":block/xloris_endlyum_side");
        textures.put("%bottom%", "minecraft:block/end_stone");
        textures.put("%overlay%", modId + ":block/xloris_endlyum_side");
        Optional<String> pattern = PatternsHelper.createJson(EnditionsPatterns.BLOCK_GRASS_BLOCK, textures);
        return ModelsHelper.fromPattern(pattern);
    }
    @Override
    @Environment(EnvType.CLIENT)
    public UnbakedModel getModelVariant(ResourceLocation stateId, BlockState blockState, Map<ResourceLocation, UnbakedModel> modelCache) {
        ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath());
        this.registerBlockModel(stateId, modelId, blockState, modelCache);
        return ModelsHelper.createRandomTopModel(modelId);
    }
    @Override
    @Environment(EnvType.CLIENT)
    public BCLRenderLayer getRenderLayer() {
        return BCLRenderLayer.CUTOUT;
    }

}
