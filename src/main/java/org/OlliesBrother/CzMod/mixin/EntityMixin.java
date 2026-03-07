package org.OlliesBrother.CzMod.mixin;

import org.OlliesBrother.CzMod.events.ElevatorEvents;

import net.minecraft.entity.Entity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "setSneaking(Z)V", at = @At("TAIL"))
    private void czmod$onSneak(boolean sneaking, CallbackInfo ci) {
        if (!sneaking) return;

        Entity self = (Entity)(Object)this;
        if (self instanceof ServerPlayerEntity player) {
            ElevatorEvents.onCrouch(player);
        }
    }
}