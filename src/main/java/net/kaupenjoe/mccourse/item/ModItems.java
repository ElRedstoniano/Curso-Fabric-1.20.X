package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.custom.MetalDetectorItem;
import net.kaupenjoe.mccourse.item.custom.PaxelItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item PINK_GARNET = addToTab(
            registerItem("pink_garnet",
            new Item(new FabricItemSettings() /*or instead use new Item.Settings()*/))
    );
    public static final Item RAW_PINK_GARNET = addToTab(registerItem("raw_pink_garnet",
            new Item(new FabricItemSettings())));

    public static final Item METAL_DETECTOR = addToTab(registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(256))));
    public static final Item CAULIFLOWER = addToTab(registerItem("cauliflower",
            new Item(new FabricItemSettings().food(ModFoodComponents.CAULIFLOWER))));
    public static final Item PEAT_BRICK = addToTab(registerItem("peat_brick",
            new Item(new FabricItemSettings())));

    public static final Item PINK_GARNET_SWORD = addToTab(registerItem("pink_garnet_sword",
            new SwordItem(ModToolMaterial.PINK_GARNET, 2, 2f,new FabricItemSettings())));
    public static final Item PINK_GARNET_PICKAXE = addToTab(registerItem("pink_garnet_pickaxe",
            new PickaxeItem(ModToolMaterial.PINK_GARNET, 1, 1f,new FabricItemSettings())));
    public static final Item PINK_GARNET_SHOVEL = addToTab(registerItem("pink_garnet_shovel",
            new ShovelItem(ModToolMaterial.PINK_GARNET, 0, 0f,new FabricItemSettings())));
    public static final Item PINK_GARNET_AXE = addToTab(registerItem("pink_garnet_axe",
            new AxeItem(ModToolMaterial.PINK_GARNET, 6, -2f,new FabricItemSettings())));
    public static final Item PINK_GARNET_HOE = addToTab(registerItem("pink_garnet_hoe",
            new HoeItem(ModToolMaterial.PINK_GARNET, 0, 0f,new FabricItemSettings())));

    public static final Item PINK_GARNET_PAXEL = addToTab(registerItem("pink_garnet_paxel",
            new PaxelItem(ModToolMaterial.PINK_GARNET, 0, 0f,new FabricItemSettings())));

    private static <T extends Item> T registerItem(String name, T item){
        /*return Registry.register(Registries.ITEM,
                new Identifier(MCCourseMod.MOD_ID, name), item);*/ // Old way
        return Registry.register(Registries.ITEM,
                MCCourseMod.id(name), item); // My new personal way to do this
    }

    private static void itemGroupIngredients(FabricItemGroupEntries entries){
        entries.add(PINK_GARNET);
        entries.add(RAW_PINK_GARNET);

        entries.add(ModBlocks.PINK_GARNET_BLOCK);
        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        entries.add(ModBlocks.PINK_GARNET_ORE);
        entries.add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        entries.add(ModBlocks.NETHER_PINK_GARNET_ORE);
        entries.add(ModBlocks.END_STONE_PINK_GARNET_ORE);
        entries.add(ModBlocks.SOUND_BLOCK);

        entries.add(METAL_DETECTOR/*, ModBlocks.END_PINK_GARNET_ORE*/);
        entries.add(CAULIFLOWER);
        entries.add(PEAT_BRICK);

    }

    private static void itemGroupTools(FabricItemGroupEntries entries){
//        entries.addAfter( Items.NETHERITE_HOE, ModItems.PINK_GARNET_SWORD);
        entries.addAfter(Items.NETHERITE_HOE,ModItems.PINK_GARNET_PICKAXE,
                ModItems.PINK_GARNET_SHOVEL,
                ModItems.PINK_GARNET_AXE,
                ModItems.PINK_GARNET_PAXEL,
                ModItems.PINK_GARNET_HOE);
    }

    private static void itemGroupCombat(FabricItemGroupEntries entries){
        entries.addAfter(Items.NETHERITE_SWORD,ModItems.PINK_GARNET_SWORD);
    }

    private static void itemGroupBuildingBlocks(FabricItemGroupEntries entries){
        entries.add(ModBlocks.PINK_GARNET_STAIRS);
        entries.add(ModBlocks.PINK_GARNET_SLAB);

        entries.add(ModBlocks.PINK_GARNET_BUTTON);
        entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

        entries.add(ModBlocks.PINK_GARNET_FENCE);
        entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
        entries.add(ModBlocks.PINK_GARNET_WALL);
        entries.add(ModBlocks.PINK_GARNET_DOOR);
        entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
    }

    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(
                /*(itemGroupEntries) -> {ModItems.itemGroupIngredients(itemGroupEntries);}*/
                ModItems::itemGroupIngredients
        );

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
                ModItems::itemGroupTools
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(
                ModItems::itemGroupCombat
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(
                ModItems::itemGroupBuildingBlocks
        );
    }

    public static Item addToTab(Item item){
        return (Item) ModItemGroup.addToTab(item);
    }
}
