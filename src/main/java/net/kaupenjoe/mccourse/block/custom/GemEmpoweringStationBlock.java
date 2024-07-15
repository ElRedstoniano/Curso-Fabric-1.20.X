package net.kaupenjoe.mccourse.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class GemEmpoweringStationBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
//    public static final VoxelShape CUBOID_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    public static final VoxelShape SHAPE = Stream.of(
        Block.createCuboidShape(14, 0, 0, 16, 4, 2),
        Block.createCuboidShape(0, 0, 0, 2, 4, 2),
        Block.createCuboidShape(0, 0, 14, 2, 4, 16),
        Block.createCuboidShape(14, 0, 14, 16, 4, 16),
        Block.createCuboidShape(0, 4, 0, 16, 12, 16))
        .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    // https://youtu.be/NqgR9vt7P5k?t=388 - Look at VoxelShapes group on the .bbmodel

    public GemEmpoweringStationBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return super.getOutlineShape(state, world, pos, context);
         return SHAPE; // Full cube shape
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return super.getPlacementState(ctx);
        return  this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        super.appendProperties(builder);
        builder.add(FACING);
    }
}
