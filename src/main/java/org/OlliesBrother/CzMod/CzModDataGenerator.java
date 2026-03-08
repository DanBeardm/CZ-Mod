package org.OlliesBrother.CzMod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.DataGenerator;
import org.OlliesBrother.CzMod.datagen.CzLootTableProvieder;
import org.OlliesBrother.CzMod.datagen.CzModelProvider;

public class CzModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack  = fabricDataGenerator.createPack();

        pack.addProvider(CzModelProvider::new);
        pack.addProvider(CzLootTableProvieder::new);
    }
}
