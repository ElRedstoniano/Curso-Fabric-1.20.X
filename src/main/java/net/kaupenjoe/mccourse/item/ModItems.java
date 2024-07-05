package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.custom.MetalDetectorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
        entries.add(ModBlocks.END_PINK_GARNET_ORE);

        entries.add(METAL_DETECTOR/*, ModBlocks.END_PINK_GARNET_ORE*/);

    }
    public static void registerModItems() {
        MCCourseMod.LOGGER.info("Registering Mod Items for " + MCCourseMod.MOD_ID);

        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(
                /*(itemGroupEntries) -> {ModItems.itemGroupIngredients(itemGroupEntries);}*/
                ModItems::itemGroupIngredients
        );
    }

    public static Item addToTab(Item item){
        return (Item) ModItemGroup.addToTab(item);
    }
}
