package net.vsh33.withertools.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Glass-style wither-proof block. Uses TransparentBlock so it does not
 * occlude; translucent rendering comes from the texture alpha in 26.1+.
 */
public class WitherProofGlassBlock extends TransparentBlock {
	public WitherProofGlassBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public void wasExploded(ServerLevel level, BlockPos pos, Explosion explosion) {
	}

	@Override
	public boolean dropFromExplosion(Explosion explosion) {
		return false;
	}

	@Override
	protected VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
		return 1.0F;
	}

	@Override
	protected boolean propagatesSkylightDown(BlockState state) {
		return true;
	}
}
