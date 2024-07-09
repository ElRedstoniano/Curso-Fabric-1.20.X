package net.kaupenjoe.mccourse.enchantment;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEnchantments {
    public static final Enchantment LIGHTING_STRIKER = register("lightning_striker",
            new LightingStrikerEnchantment(Enchantment.Rarity.COMMON,
            EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT, MCCourseMod.id(name), enchantment);
    }

    public static void registerModEnchantments(){

        MCCourseMod.LOGGER.info("Registering mod enchantments for " + MCCourseMod.MOD_ID);
    }
}
