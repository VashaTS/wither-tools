package net.vsh33.withertools.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.block.state.BlockState;
import net.vsh33.withertools.block.ModBlocks;

/**
 * Extra safeguard matching the 1.21.1 mixin: refuse to break our wither-proof
 * blocks during the Wither's hurt-triggered block destruction. Primary
 * protection is {@code #minecraft:wither_immune}; this catches edge cases.
 */
@Mixin(WitherBoss.class)
public abstract class WitherBossMixin {
	@Redirect(
			method = "customServerAiStep",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/server/level/ServerLevel;destroyBlock(Lnet/minecraft/core/BlockPos;ZLnet/minecraft/world/entity/Entity;)Z"
			)
	)
	private boolean withertools$protectBlocks(ServerLevel level, BlockPos pos, boolean drop, Entity breakingEntity) {
		BlockState state = level.getBlockState(pos);
		if (state.is(BlockTags.WITHER_IMMUNE)
				|| state.is(ModBlocks.WITHERPROOF_BLOCK)
				|| state.is(ModBlocks.WITHERPROOF_GLASS)) {
			return false;
		}
		return level.destroyBlock(pos, drop, breakingEntity);
	}
}
