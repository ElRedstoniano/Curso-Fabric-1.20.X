package net.kaupenjoe.mccourse.item.custom;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.kaupenjoe.mccourse.item.ModItems;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.kaupenjoe.mccourse.util.ColorUtil;
import net.kaupenjoe.mccourse.util.InventoryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Colors;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.text.NumberFormat;
import java.util.List;

import static net.kaupenjoe.mccourse.util.ColorUtil.removeAlpha;

public class MetalDetectorItem extends Item {
    //private NumberFormat stringFormatter = NumberFormat.getInstance();
    private NumberFormat numberFormatter = NumberFormat.getNumberInstance();
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundblock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState blockState = context.getWorld().getBlockState(positionClicked.down(i));
                Block block = blockState.getBlock();

                if(isValuableBlock(blockState)){
                    outputValuableCoordinates(positionClicked.down(i), player, block);
                    foundblock = true;

                    if(InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET)){
                        addNbtDataToDataTablet(player, positionClicked.down(i), block);
                    }

                    context.getWorld().playSound(null, positionClicked, ModSounds.METAL_DETECTOR_FOUND_ORE,
                            SoundCategory.BLOCKS, 1f, 1f);

                    break;
                }
            }

            if(!foundblock){
                player.sendMessage(Text.translatable("item.mccourse.metal_detector.no_valuables"));
            }
        }

        context.getStack().damage(1, context.getPlayer(), playerEntity ->
                playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        //return super.useOnBlock(context);
        return ActionResult.SUCCESS;
    }

    private void addNbtDataToDataTablet(PlayerEntity player, BlockPos position, Block block) {
        ItemStack dataTabletStack = player.getInventory()
                .getStack(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET));

        NbtCompound nbtData = new NbtCompound();
        String putString = Text.Serializer.toJson(
                Text.translatable("item.mccourse.metal_detector.found", coloredFromBlockText(block),
                        Text.of("(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")")
                                .copy().setStyle(Style.EMPTY.withColor(rgbTextColor(Color.CYAN))
                                        /*TextColor.fromRgb(Color.CYAN.getRGB()))))*/)));
        nbtData.putString("mccourse.last_valuable_found", putString);

        dataTabletStack.setNbt(nbtData);
    }

    private TextColor rgbTextColor(Color color) {
        return TextColor.fromRgb(ColorUtil.removeAlpha(color).getRGB());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.mccourse.metal_detector.tooltip"));
        }

        //super.appendTooltip(stack, world, tooltip, context);
    }

    private void outputValuableCoordinates(BlockPos position, PlayerEntity player, Block block) {
        /*player.sendMessage( Text.of(
                Text.translatable("item.mccourse.metal_detector.found").getString()
                        + Text.literal(block.getName().getString() + " at " + "(" + position.getX() + ", " +
                        position.getY() + ", " + position.getZ() + ")").getString())
        );*/ // Outdated
        // numberFormatter.format(position.getY()) also outdated as it's not longer used

        player.sendMessage(Text.translatable("item.mccourse.metal_detector.found", coloredFromBlockText(block),
                Text.of("(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")")
                        .copy().setStyle(Style.EMPTY.withColor(TextColor.fromRgb(Color.CYAN.getRGB()))))

        );
    }

    private MutableText coloredFromBlockText(Block block) {
        return Text.translatable(/*block.getName().getString()*/block.getTranslationKey()).copy().setStyle(
                Style.EMPTY.withColor(block.getDefaultMapColor().color));
    }


    private boolean isValuableBlock(BlockState blockState) {
        //return blockState.getBlock() == Blocks.IRON_ORE;
        /*return  blockState.isIn(BlockTags.GOLD_ORES) || blockState.isIn(BlockTags.IRON_ORES)
                || blockState.isIn(BlockTags.DIAMOND_ORES) || blockState.isIn(BlockTags.REDSTONE_ORES)
                || blockState.isIn(BlockTags.LAPIS_ORES) || blockState.isIn(BlockTags.COAL_ORES)
                || blockState.isIn(BlockTags.EMERALD_ORES) || blockState.isIn(BlockTags.COPPER_ORES);*/
        return  blockState.isIn(ConventionalBlockTags.ORES) || blockState.isIn(ConventionalBlockTags.CHESTS)
                || blockState.isIn(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS);
        // Using fabric ores tag & chests
    }
}
