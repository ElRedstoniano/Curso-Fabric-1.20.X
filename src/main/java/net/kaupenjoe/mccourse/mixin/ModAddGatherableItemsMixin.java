package net.kaupenjoe.mccourse.mixin;

import com.google.common.collect.ImmutableSet;
import net.kaupenjoe.mccourse.item.ModItemGroup;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.*;

import java.util.Set;

@Debug(export = true)
@Mixin(VillagerEntity.class)
public class ModAddGatherableItemsMixin {
//    private static Item[] itemarray = new Item[]{Items.BREAD};


    @SuppressWarnings("ShadowModifiers")
    @Shadow @Final
    public static Set<Item> GATHERABLE_ITEMS;

    static {
        ModItemGroup.registerItemGroup();
        //noinspection ShadowFinalModification
        GATHERABLE_ITEMS = ImmutableSet.<Item>builder()
                .addAll(GATHERABLE_ITEMS)
                .add(Items.MELON)
                .add(ModItems.CAULIFLOWER_SEEDS)
                .build();
    }
}
