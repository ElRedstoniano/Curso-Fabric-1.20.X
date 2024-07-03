package net.kaupenjoe.mccourse.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ModItemGroup {
    public static final List<ItemConvertible> PINK_GARNET_GROUP_ITEMS = new ArrayList<>();

    public static final ItemGroup PINK_GARNET_GROUP = Registry.register(Registries.ITEM_GROUP,
            MCCourseMod.id("pink_garnet_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pink_garnet_group"))
                .icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .entries((displayContext, entries) -> {
                        /*entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);

                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);*/
                        PINK_GARNET_GROUP_ITEMS.forEach( (item) -> entries.add(item));

                }).build());
    public static void registerItemGroup(){

    }

    public static ItemConvertible addToTab(ItemConvertible item){
        ///*<T extends Item> T*/ outdated
        PINK_GARNET_GROUP_ITEMS.add(item);
        return item;
    }
}
