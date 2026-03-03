package org.OlliesBrother.CzMod.block;



import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.OlliesBrother.CzMod.CzBlocks;

public final class ElevatorUtil {
    public static final int MAX_RANGE = 128;

    private ElevatorUtil() {}

    public static void tryTeleport(ServerPlayerEntity player, boolean down) {
        ServerWorld world = (ServerWorld) player.getWorld();

        // Player feet block, so elevator should be directly below
        BlockPos originElevator = player.getBlockPos().down();
        if (!world.getBlockState(originElevator).isOf(CzBlocks.ELEVATOR)) return;

        BlockPos targetElevator = findNextElevator(world, originElevator, down);
        if (targetElevator == null) {
            player.sendMessage(Text.literal(down ? "No elevator below." : "No elevator above."), true);
            return;
        }

        BlockPos feet = targetElevator.up();
        if (!hasTwoBlockHeadroom(world, feet)) {
            player.sendMessage(Text.literal("Destination is blocked."), true);
            return;
        }

        player.teleport(world, feet.getX() + 0.5, feet.getY(), feet.getZ() + 0.5, player.getYaw(), player.getPitch());
        player.setVelocity(0, 0, 0);
        player.velocityModified = true;

        world.playSound(null, targetElevator, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }

    private static BlockPos findNextElevator(ServerWorld world, BlockPos origin, boolean down) {
        int step = down ? -1 : 1;

        int minY = world.getBottomY();
        int maxY = world.getTopY() - 1;

        for (int i = 1; i <= MAX_RANGE; i++) {
            int y = origin.getY() + (i * step);
            if (y < minY || y > maxY) break;

            BlockPos check = new BlockPos(origin.getX(), y, origin.getZ());
            if (world.getBlockState(check).isOf(CzBlocks.ELEVATOR)) {
                return check;
            }
        }
        return null;
    }

    private static boolean hasTwoBlockHeadroom(ServerWorld world, BlockPos feetPos) {
        BlockPos headPos = feetPos.up();
        return world.getBlockState(feetPos).getCollisionShape(world, feetPos).isEmpty()
                && world.getBlockState(headPos).getCollisionShape(world, headPos).isEmpty()
                && world.getFluidState(feetPos).isEmpty()
                && world.getFluidState(headPos).isEmpty();
    }
}