package org.OlliesBrother.CzMod.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import org.OlliesBrother.CzMod.block.CzBlocks;

public class CzModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(CzBlocks.OLLIESBROTHER_FIGURE, RenderLayer.getCutout());
    }
}