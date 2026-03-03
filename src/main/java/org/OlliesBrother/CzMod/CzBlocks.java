package org.OlliesBrother.CzMod;

import org.OlliesBrother.CzMod.block.ElevatorBlock;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

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

    public static void init() {}

    private CzBlocks() {}
}