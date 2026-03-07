package org.OlliesBrother.CzMod;

import net.fabricmc.api.ModInitializer;
import org.OlliesBrother.CzMod.block.CzBlocks;
import org.OlliesBrother.CzMod.component.CzDataComponentTypes;
import org.OlliesBrother.CzMod.item.CzItemGroups;
import org.OlliesBrother.CzMod.item.CzItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CzMod implements ModInitializer {
    public static final String MOD_ID = "czmod"; // must match fabric.mod.json "id"
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CzItems.init();
        CzItemGroups.init();
        CzBlocks.registerModBlocks();
        CzDataComponentTypes.registerDataComponentTypes();

    }
}
