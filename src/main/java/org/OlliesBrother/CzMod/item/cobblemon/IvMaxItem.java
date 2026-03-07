package org.OlliesBrother.CzMod.item.cobblemon;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.api.pokemon.stats.Stat;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.IVs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import java.util.List;

public class IvMaxItem extends Item {
    private final Stat stat;
    private final String statLabel;

    public IvMaxItem(Settings settings, Stat stat, String statLabel) {
        super(settings);
        this.stat = stat;
        this.statLabel = statLabel;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getWorld().isClient) return ActionResult.SUCCESS;
        if (!(entity instanceof PokemonEntity pokemonEntity)) return ActionResult.PASS;

        var pokemon = pokemonEntity.getPokemon();

        // Only allow boosting your own Pokémon
        if (!pokemon.belongsTo(user)) {
            user.sendMessage(Text.literal("That Pokémon isn't yours!"), true);
            return ActionResult.FAIL;
        }

        int current = pokemon.getIvs().getOrDefault(stat);
        int max = IVs.MAX_VALUE; // 31

        if (current >= max) {
            user.sendMessage(Text.literal("Already max " + statLabel + " IV (31)."), true);
            return ActionResult.FAIL;
        }

        // Sets NATURAL IVs (not hyper trained)
        pokemon.setIV(stat, max);

        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        user.getWorld().playSound(
                null,
                pokemonEntity.getBlockPos(),
                CobblemonSounds.BERRY_EAT,
                SoundCategory.PLAYERS,
                1.0f,
                1.0f
        );

        user.sendMessage(Text.literal(statLabel + " IV set to 31 (" + current + " → 31)"), true);
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("Right-click your Cobblemon: set " + statLabel + " IV to 31"));
    }
}