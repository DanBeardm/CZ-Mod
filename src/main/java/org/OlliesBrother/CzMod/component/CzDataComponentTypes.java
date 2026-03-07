package org.OlliesBrother.CzMod.component;

import org.OlliesBrother.CzMod.CzMod;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class CzDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES =
            register("coordinates", builder -> builder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(CzMod.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        CzMod.LOGGER.info("Registering data component types for " + CzMod.MOD_ID);
    }
}
