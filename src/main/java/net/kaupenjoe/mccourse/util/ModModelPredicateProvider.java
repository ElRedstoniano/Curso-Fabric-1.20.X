package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void  registerModModels(){
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, MCCourseMod.id("on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);

        registerBow(ModItems.PINK_GARNET_BOW);

        ModelPredicateProviderRegistry.register(
                ModItems.PINK_GARNET_SHIELD,
                new Identifier("blocking"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }

    private static void registerBow(Item bow){
        // Took a look from ModelPredicateProviderRegistry class
        ModelPredicateProviderRegistry.register(bow, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });
        ModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
