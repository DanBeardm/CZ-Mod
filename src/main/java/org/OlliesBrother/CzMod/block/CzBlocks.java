package org.OlliesBrother.CzMod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import org.OlliesBrother.CzMod.CzMod;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.OlliesBrother.CzMod.block.elevator.ElevatorBlock;
import org.OlliesBrother.CzMod.block.figures.FigureBlock;

public final class CzBlocks {

    public static final Block ELEVATOR = registerBlock("elevator",
            new ElevatorBlock(AbstractBlock.Settings.create()
                    .strength(1.3f)
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block OLLIESBROTHER_FIGURE = registerBlock("olliesbrother_figure",
            new FigureBlock(AbstractBlock.Settings.create()
                    .nonOpaque()
                    .strength(0.3f)
                    .sounds(BlockSoundGroup.WOOL)
                    .noBlockBreakParticles()

            )
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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(CzBlocks.ELEVATOR);
            entries.add(CzBlocks.OLLIESBROTHER_FIGURE);
        });
    }

}