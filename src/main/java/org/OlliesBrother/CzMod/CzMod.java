package org.OlliesBrother.CzMod;

import net.fabricmc.api.ModInitializer;

public class CzMod implements ModInitializer {
    public static final String MOD_ID = "czmod"; // must match fabric.mod.json "id"

    @Override
    public void onInitialize() {
        CzItems.init();
        CzBlocks.init();
        CzNetworking.init();
        CzItemGroups.init();
    }
}
