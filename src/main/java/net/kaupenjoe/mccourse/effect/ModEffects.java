package net.kaupenjoe.mccourse.effect;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEffects {
    public static final StatusEffect SLIMEY = registerStatusEffect("slimey",
            new SlimeyEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25f, // UUID random
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect){
        return Registry.register(Registries.STATUS_EFFECT, MCCourseMod.id(name), effect);
    }

    public static void registerEffects(){
        MCCourseMod.LOGGER.info("Registering Mod Effects for " + MCCourseMod.MOD_ID);
    }
}
