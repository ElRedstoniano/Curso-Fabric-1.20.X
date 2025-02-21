package net.kaupenjoe.mccourse.block.custom;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SoundBlock extends Block {
    public SoundBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
    /*
        //Note: This method gets called "four times" (for both hands and twice for each hand (client and server side))
        if(world.isClient()){
            if(hand == Hand.MAIN_HAND){
                MCCourseMod.LOGGER.info("CLIENT | Main Hand");
            } else {
                MCCourseMod.LOGGER.info("CLIENT | Off Hand");
            }
        } else {
            if(hand == Hand.MAIN_HAND){
                MCCourseMod.LOGGER.info("SERVER | Main Hand");
            } else {
                MCCourseMod.LOGGER.info("SERVER | Off Hand");
            }
        }*/

        if(player.isSneaking()){
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_BANJO.value(),
                    SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.SUCCESS;
        } else {
            world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_COW_BELL.value(),
                    SoundCategory.BLOCKS, 1f, 1f);
            return ActionResult.CONSUME;
        }

        //return super.onUse(state, world, pos, player, hand, hit);
//        return  ActionResult.SUCCESS; // Does a swing animation of the hand but only for the main hand
        // (See ActionResult enums)
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        world.playSound(entity, pos, SoundEvents.BLOCK_NOTE_BLOCK_BIT.value(),
                SoundCategory.BLOCKS, 1f, 1f);

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.mccourse.sound_block"));
        //super.appendTooltip(stack, world, tooltip, options);
    }
}
