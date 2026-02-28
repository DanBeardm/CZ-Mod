package org.OlliesBrother.CzMod;

import com.cobblemon.mod.common.api.pokemon.stats.Stats;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.OlliesBrother.CzMod.item.IvMaxItem;
import org.OlliesBrother.CzMod.item.IvPlusOneItem;
import org.OlliesBrother.CzMod.item.ShinyToggleItem;

public class CzItems {
    public static final Item HP_IV_PLUS_ONE = register("hp_iv_plus_one",
            new IvPlusOneItem(new Item.Settings().maxCount(64), Stats.HP, "HP"));

    public static final Item ATK_IV_PLUS_ONE = register("attack_iv_plus_one",
            new IvPlusOneItem(new Item.Settings().maxCount(64), Stats.ATTACK, "Attack"));

    public static final Item DEF_IV_PLUS_ONE = register("defence_iv_plus_one",
            new IvPlusOneItem(new Item.Settings().maxCount(64), Stats.DEFENCE, "Defence"));

    public static final Item SPA_IV_PLUS_ONE = register("special_attack_iv_plus_one",
            new IvPlusOneItem(new Item.Settings().maxCount(64), Stats.SPECIAL_ATTACK, "Sp. Atk"));

    public static final Item SPD_IV_PLUS_ONE = register("special_defence_iv_plus_one",
            new IvPlusOneItem(new Item.Settings().maxCount(64), Stats.SPECIAL_DEFENCE, "Sp. Def"));

    public static final Item SPE_IV_PLUS_ONE = register("speed_iv_plus_one",
            new IvPlusOneItem(new Item.Settings().maxCount(64), Stats.SPEED, "Speed"));

    public static final Item HP_IV_MAX = register("hp_iv_max",
            new IvMaxItem(new Item.Settings().maxCount(64), Stats.HP, "HP"));

    public static final Item ATK_IV_MAX = register("attack_iv_max",
            new IvMaxItem(new Item.Settings().maxCount(64), Stats.ATTACK, "Attack"));

    public static final Item DEF_IV_MAX = register("defence_iv_max",
            new IvMaxItem(new Item.Settings().maxCount(64), Stats.DEFENCE, "Defence"));

    public static final Item SPA_IV_MAX = register("special_attack_iv_max",
            new IvMaxItem(new Item.Settings().maxCount(64), Stats.SPECIAL_ATTACK, "Sp. Atk"));

    public static final Item SPD_IV_MAX = register("special_defence_iv_max",
            new IvMaxItem(new Item.Settings().maxCount(64), Stats.SPECIAL_DEFENCE, "Sp. Def"));

    public static final Item SPE_IV_MAX = register("speed_iv_max",
            new IvMaxItem(new Item.Settings().maxCount(64), Stats.SPEED, "Speed"));

    public static final Item SHINIFIER = register(
            "shinifier",
            new ShinyToggleItem(new Item.Settings().maxCount(64))
    );
    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CzMod.MOD_ID, id), item);
    }
    public static void init() {}

}