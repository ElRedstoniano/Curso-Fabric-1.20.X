package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ModItemGroup {
    public static final List<ItemConvertible> PINK_GARNET_GROUP_ITEMS = new ArrayList<>();

    private static final Text itemGroupTitle = Text.translatable("itemgroup.pink_garnet_group");
    public static final ItemGroup PINK_GARNET_GROUP = Registry.register(Registries.ITEM_GROUP,
            MCCourseMod.id("pink_garnet_group"),
            FabricItemGroup.builder()
                    .displayName(itemGroupTitle)
                    .icon(ModItems.PINK_GARNET::getDefaultStack) /*() -> new ItemStack(ModItems.PINK_GARNET)*/
                    .entries((displayContext, entries) -> {
                        /*entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);*/
                        PINK_GARNET_GROUP_ITEMS.forEach( (item) -> entries.add(item));
                        //System.out.println("TEST1: " + PINK_GARNET_GROUP_ITEMS);

                        //Add something to order the list by items and blocks

                        //Alternate method: do Registries.ITEM.getds() and stream, filter by modId and map to optional
                        // to then get rid of it and get the value and do entries::add
                        // https://youtu.be/W7JFbcQzCA4?t=489

                }).build());
    public static void registerItemGroup(){

    }

    public static ItemConvertible addToTab(ItemConvertible item){
        ///*<T extends Item> T*/ outdated
        PINK_GARNET_GROUP_ITEMS.add(item);
        return item;
    }
}
