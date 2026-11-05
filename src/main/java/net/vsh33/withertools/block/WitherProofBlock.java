package net.vsh33.withertools.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Solid wither-proof block. Wither immunity also comes from the
 * {@code #minecraft:wither_immune} tag and high blast resistance; this
 * override mirrors the 1.21.1 behaviour of ignoring explosion destruction.
 */
public class WitherProofBlock extends Block {
	public WitherProofBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public void wasExploded(ServerLevel level, BlockPos pos, Explosion explosion) {
		// Intentionally empty — do not run default explosion side-effects.
	}

	@Override
	public boolean dropFromExplosion(Explosion explosion) {
		return false;
	}
}
