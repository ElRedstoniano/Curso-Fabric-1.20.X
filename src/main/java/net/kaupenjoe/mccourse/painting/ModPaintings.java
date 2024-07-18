package net.kaupenjoe.mccourse.painting;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModPaintings {
    public static final PaintingVariant SAW_THEM = registerPaintings("saw_them", new PaintingVariant(16, 16));
    public static final PaintingVariant SHRIMP = registerPaintings("shrimp", new PaintingVariant(32, 16));
    public static final PaintingVariant WORLD = registerPaintings("world", new PaintingVariant(32, 32));

    private static PaintingVariant registerPaintings(String name, PaintingVariant paintingVariant){
        return Registry.register(Registries.PAINTING_VARIANT, MCCourseMod.id(name), paintingVariant);
    }
    public static void registerPaintings(){
        MCCourseMod.LOGGER.info("Registering paintings for " + MCCourseMod.MOD_ID);
    }
}
