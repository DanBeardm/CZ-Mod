package org.OlliesBrother.CzMod.net;

import org.OlliesBrother.CzMod.CzMod;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ElevatorUpPayload() implements CustomPayload {
    public static final Id<ElevatorUpPayload> ID =
            new Id<>(Identifier.of(CzMod.MOD_ID, "elevator_up"));

    // No data -> codec that always returns the same "unit" value
    public static final PacketCodec<PacketByteBuf, ElevatorUpPayload> CODEC =
            PacketCodec.unit(new ElevatorUpPayload()); // :contentReference[oaicite:2]{index=2}

    @Override
    public Id<? extends CustomPayload> getId() { // :contentReference[oaicite:3]{index=3}
        return ID;
    }
}