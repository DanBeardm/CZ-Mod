package org.OlliesBrother.CzMod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import org.OlliesBrother.CzMod.block.CzBlocks;
import org.OlliesBrother.CzMod.item.CzItems;

public class CzModelProvider extends FabricModelProvider {
    public CzModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(CzBlocks.OLLIESBROTHER_FIGURE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(CzItems.AXO_CRATE, Models.GENERATED);
    }
}
