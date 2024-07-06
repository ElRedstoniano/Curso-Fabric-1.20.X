package net.kaupenjoe.mccourse.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.custom.SoundBlock;
import net.kaupenjoe.mccourse.item.ModItemGroup;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = addToTab(registerBlock("pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))));
    public static final Block RAW_PINK_GARNET_BLOCK = addToTab(registerBlock("raw_pink_garnet_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK))));

    public static final Block PINK_GARNET_ORE = addToTab(registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE),
                    UniformIntProvider.create(3, 6))));
    public static final Block NETHER_PINK_GARNET_ORE = addToTab(registerBlock("nether_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHER_GOLD_ORE),
                    UniformIntProvider.create(3, 6))));
    public static final Block END_STONE_PINK_GARNET_ORE = addToTab(registerBlock("end_stone_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE),
                    UniformIntProvider.create(3, 6))));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = addToTab(registerBlock("deepslate_pink_garnet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE),
                    UniformIntProvider.create(3, 6))));
    public static final Block PINK_GARNET_STAIRS = addToTab(registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))));
    public static final Block PINK_GARNET_SLAB = addToTab(registerBlock("pink_garnet_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))));


    public static final Block SOUND_BLOCK = addToTab(registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))));

    private static <T extends Block> T registerBlock(String name, T block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, MCCourseMod.id(name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, MCCourseMod.id(name), new BlockItem(block,
                new FabricItemSettings()));
    }
    public static void registerModBlocks(){
        MCCourseMod.LOGGER.info("Registering ModBlocks for " + MCCourseMod.MOD_ID);
    }

    public static Block addToTab(Block block){
        return (Block) ModItemGroup.addToTab(block);
    }
}
