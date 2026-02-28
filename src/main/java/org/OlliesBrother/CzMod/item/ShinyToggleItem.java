package org.OlliesBrother.CzMod.item;

import com.cobblemon.mod.common.CobblemonSounds;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ShinyToggleItem extends Item {

    public ShinyToggleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getWorld().isClient) return ActionResult.SUCCESS;
        if (!(entity instanceof PokemonEntity pokemonEntity)) return ActionResult.PASS;

        var pokemon = pokemonEntity.getPokemon();

        // Only allow on your own Pokémon
        if (!pokemon.belongsTo(user)) {
            user.sendMessage(Text.literal("That Pokémon isn't yours!"), true);
            return ActionResult.FAIL;
        }

        boolean wasShiny = pokemon.getShiny();
        pokemon.setShiny(!wasShiny);

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

        user.sendMessage(
                Text.literal(wasShiny ? "Shiny removed." : "Shiny applied!"),
                true
        );

        return ActionResult.SUCCESS;
    }
}