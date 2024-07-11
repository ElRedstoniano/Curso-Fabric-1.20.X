package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;

public class ModModelPredicateProvider {
    public static void  registerModModels(){
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, MCCourseMod.id("on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);
    }
}
