package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.custom.*;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

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
            new ModPoisonSwordItem(ModToolMaterial.PINK_GARNET, 2, 2f,new FabricItemSettings())));
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

    public static final Item PINK_GARNET_HELMET = addToTab(registerItem("pink_garnet_helmet",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET, ArmorItem.Type.HELMET ,new FabricItemSettings())));
    public static final Item PINK_GARNET_CHESTPLATE = addToTab(registerItem("pink_garnet_chestplate",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET, ArmorItem.Type.CHESTPLATE ,new FabricItemSettings())));
    public static final Item PINK_GARNET_LEGGINGS = addToTab(registerItem("pink_garnet_leggings",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET, ArmorItem.Type.LEGGINGS ,new FabricItemSettings())));
    public static final Item PINK_GARNET_BOOTS = addToTab(registerItem("pink_garnet_boots",
            new ModArmorItem(ModArmorMaterials.PINK_GARNET, ArmorItem.Type.BOOTS ,new FabricItemSettings())));
    // Note: It's not necessary to apply ModArmorItem class to all armor items, just adding one will execute the code on
    // the ModArmorItem class

    public static final Item CAULIFLOWER_SEEDS = addToTab(registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP,new FabricItemSettings())));

    public static final Item PINK_GARNET_HORSE_ARMOR = addToTab(registerItem("pink_garnet_horse_armor",
            new HorseArmorItem(14, "pink_garnet"/*3d model name*/ ,new FabricItemSettings())));

    public static final Item DATA_TABLET = addToTab(registerItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().maxCount(1 ))));

    public static final Item BAR_BRAWL_MUSIC_DISC = addToTab(registerItem("bar_brawl_music_disc",
            new MusicDiscItem(9, ModSounds.BAR_BRAWL,
                    new FabricItemSettings().maxCount(1 ).rarity(Rarity.RARE), 122)));

    public static final Item RADIATION_STAFF = addToTab(registerItem("radiation_staff",
            new Item(new FabricItemSettings().rarity(Rarity.RARE))));

    public static final Item PINK_GARNET_BOW = addToTab(registerItem("pink_garnet_bow",
            new BowItem(new FabricItemSettings().maxDamage(500))));

    public static final Item PINK_GARNET_SHIELD = addToTab(registerItem("pink_garnet_shield",
            new ShieldItem(new FabricItemSettings().maxDamage(500))));



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
        entries.add(CAULIFLOWER_SEEDS);

    }

    private static void itemGroupTools(FabricItemGroupEntries entries){
//        entries.addAfter( Items.NETHERITE_HOE, ModItems.PINK_GARNET_SWORD);
        entries.addAfter(Items.NETHERITE_HOE,ModItems.PINK_GARNET_PICKAXE,
                ModItems.PINK_GARNET_SHOVEL,
                ModItems.PINK_GARNET_AXE,
                ModItems.PINK_GARNET_PAXEL,
                ModItems.PINK_GARNET_HOE,
                ModItems.DATA_TABLET
                );
    }

    private static void itemGroupCombat(FabricItemGroupEntries entries){
        entries.addAfter(Items.NETHERITE_SWORD,ModItems.PINK_GARNET_SWORD,
                ModItems.PINK_GARNET_HELMET,
                ModItems.PINK_GARNET_CHESTPLATE,
                ModItems.PINK_GARNET_LEGGINGS,
                ModItems.PINK_GARNET_BOOTS,
                ModItems.PINK_GARNET_HORSE_ARMOR
                );
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
        entries.add(ModBlocks.PINK_GARNET_LAMP_BLOCK);
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
