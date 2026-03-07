package org.OlliesBrother.CzMod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ModelProvider;
import org.OlliesBrother.CzMod.block.CzBlocks;

public class CzModelProvider extends ModelProvider {
    public CzModelProvider(FabricDataOutput output) {
        super(output);
    }

    //@Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(CzBlocks.FIGURE);
    }

}
