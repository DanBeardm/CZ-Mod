package org.OlliesBrother.CzMod;

import org.OlliesBrother.CzMod.block.ElevatorUtil;
import org.OlliesBrother.CzMod.net.ElevatorDownPayload;
import org.OlliesBrother.CzMod.net.ElevatorUpPayload;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public final class CzNetworking {

    public static void init() {
        // Register codecs so the client can ENCODE and server can DECODE
        PayloadTypeRegistry.playC2S().register(ElevatorUpPayload.ID, ElevatorUpPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(ElevatorDownPayload.ID, ElevatorDownPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(ElevatorUpPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                var player = context.player();
                if (!player.isOnGround()) return;
                ElevatorUtil.tryTeleport(player, false);
            });
        });

        ServerPlayNetworking.registerGlobalReceiver(ElevatorDownPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                var player = context.player();
                if (!player.isOnGround()) return;
                ElevatorUtil.tryTeleport(player, true);
            });
        });
    }

    private CzNetworking() {}
}