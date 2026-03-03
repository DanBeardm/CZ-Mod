package org.OlliesBrother.CzMod.client;

import org.OlliesBrother.CzMod.CzBlocks;
import org.OlliesBrother.CzMod.net.ElevatorUpPayload;
import org.OlliesBrother.CzMod.net.ElevatorDownPayload;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.math.BlockPos;

public class CzModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;
            if (client.currentScreen != null) return;

            BlockPos below = client.player.getBlockPos().down();
            if (!client.world.getBlockState(below).isOf(CzBlocks.ELEVATOR)) return;
            if (!client.player.isOnGround()) return;

            while (client.options.jumpKey.wasPressed()) {
                if (ClientPlayNetworking.canSend(ElevatorUpPayload.ID)) { // :contentReference[oaicite:5]{index=5}
                    ClientPlayNetworking.send(new ElevatorUpPayload());   // 1 arg :contentReference[oaicite:6]{index=6}
                }
            }

            while (client.options.sneakKey.wasPressed()) {
                if (ClientPlayNetworking.canSend(ElevatorDownPayload.ID)) {
                    ClientPlayNetworking.send(new ElevatorDownPayload());
                }
            }
        });
    }
}