package org.OlliesBrother.CzMod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import org.OlliesBrother.CzMod.block.CzBlocks;
import java.util.concurrent.CompletableFuture;

public class CzLootTableProvieder extends FabricBlockLootTableProvider {
    public CzLootTableProvieder (FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(CzBlocks.ELEVATOR);
        addDrop(CzBlocks.OLLIESBROTHER_FIGURE);
    }
}
