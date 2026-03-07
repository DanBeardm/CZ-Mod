package org.OlliesBrother.CzMod.mixin;

import org.OlliesBrother.CzMod.events.ElevatorEvents;

import net.minecraft.entity.LivingEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "jump", at = @At("HEAD"), cancellable = true)
    private void czmod$onJump(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;

        // Only run on the real server-side player entity
        if (self instanceof ServerPlayerEntity player) {
            if (ElevatorEvents.onJump(player)) {
                ci.cancel(); // prevent the normal jump if we teleported
            }
        }
    }
}