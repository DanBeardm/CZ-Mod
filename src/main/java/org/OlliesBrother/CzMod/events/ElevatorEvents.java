package org.OlliesBrother.CzMod.events;

import org.OlliesBrother.CzMod.block.elevator.ElevatorUtil;

import net.minecraft.server.network.ServerPlayerEntity;

public final class ElevatorEvents {
    private ElevatorEvents() {}

    public static void onCrouch(ServerPlayerEntity player) {
        // Sneak = down
        ElevatorUtil.tryTeleport(player, true);
    }

    public static boolean onJump(ServerPlayerEntity player) {
        // Jump = up
        return ElevatorUtil.tryTeleport(player, false);
    }
}