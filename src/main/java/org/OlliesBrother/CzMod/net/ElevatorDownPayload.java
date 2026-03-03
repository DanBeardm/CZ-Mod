package org.OlliesBrother.CzMod.net;

import org.OlliesBrother.CzMod.CzMod;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ElevatorDownPayload() implements CustomPayload {
    public static final Id<ElevatorDownPayload> ID =
            new Id<>(Identifier.of(CzMod.MOD_ID, "elevator_down"));

    public static final PacketCodec<PacketByteBuf, ElevatorDownPayload> CODEC =
            PacketCodec.unit(new ElevatorDownPayload());

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}