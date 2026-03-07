package org.OlliesBrother.CzMod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.OlliesBrother.CzMod.CzMod;
import org.OlliesBrother.CzMod.block.CzBlocks;

public final class CzItemGroups {

    public static final ItemGroup CZ_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(CzMod.MOD_ID, "cz_group"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.czmod.cz_group"))
                    .icon(() -> new ItemStack(CzItems.SPE_IV_MAX)) // pick your icon item
                    .entries((context, entries) -> {
                        // +1 IV items
                        entries.add(CzItems.HP_IV_PLUS_ONE);
                        entries.add(CzItems.ATK_IV_PLUS_ONE);
                        entries.add(CzItems.DEF_IV_PLUS_ONE);
                        entries.add(CzItems.SPA_IV_PLUS_ONE);
                        entries.add(CzItems.SPD_IV_PLUS_ONE);
                        entries.add(CzItems.SPE_IV_PLUS_ONE);

                        // MAX IV items
                        entries.add(CzItems.HP_IV_MAX);
                        entries.add(CzItems.ATK_IV_MAX);
                        entries.add(CzItems.DEF_IV_MAX);
                        entries.add(CzItems.SPA_IV_MAX);
                        entries.add(CzItems.SPD_IV_MAX);
                        entries.add(CzItems.SPE_IV_MAX);

                        // Shinifier
                        entries.add(CzItems.SHINIFIER);

                        entries.add(CzBlocks.ELEVATOR_ITEM);
                        entries.add(CzBlocks.FIGURE_ITEM);
                    })
                    .build()
    );

    //public static final ItemGroup CZ_FIGURES = Registry.register(
//Registries.ITEM_GROUP,
      //      Identifier.of(CzMod.MOD_ID, "cz_figures"),
      //      FabricItemGroup.builder()
      //              .displayName(Text.translatable("itemGroup.czmod.cz_figures"))
      //              .icon(() -> new ItemStack(CzBlocks.OLLIESBROTHER_FIGURE))
      //              .entries((displayContext, entries) -> {
       //                 entries.add(CzBlocks.OLLIESBROTHER_FIGURE);
//})
     //               .build()
    //);

    public static void init() {
        // just forces class load
    }

    private CzItemGroups() {}
}