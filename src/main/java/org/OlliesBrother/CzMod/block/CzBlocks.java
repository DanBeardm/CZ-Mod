package org.OlliesBrother.CzMod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.OlliesBrother.CzMod.CzMod;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.OlliesBrother.CzMod.block.elevator.ElevatorBlock;
import org.OlliesBrother.CzMod.block.figures.FigureBlock;

public final class CzBlocks {

    public static final Block ELEVATOR = Registry.register(
            Registries.BLOCK,
            Identifier.of(CzMod.MOD_ID, "elevator"),
            new ElevatorBlock(AbstractBlock.Settings.create()
                    .strength(2.0f)
                    .sounds(BlockSoundGroup.METAL)
                    .requiresTool())
    );

    public static final Item ELEVATOR_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of(CzMod.MOD_ID, "elevator"),
            new BlockItem(ELEVATOR, new Item.Settings())
    );

    public static final Block FIGURE = registerBlock("figure",
            new FigureBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Item FIGURE_ITEM = Registry.register(
            Registries.ITEM,
            Identifier.of(CzMod.MOD_ID, "figure"),
            new BlockItem(FIGURE, new Item.Settings())
    );

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(CzMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(CzMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(CzMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        CzMod.LOGGER.info("Registering Mod Blocks for " + CzMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

        //});
    }

}