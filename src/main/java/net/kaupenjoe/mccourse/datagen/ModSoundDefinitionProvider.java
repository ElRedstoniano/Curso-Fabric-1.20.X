package net.kaupenjoe.mccourse.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.datagen.provider.CustomFabricSoundProvider;
import net.kaupenjoe.mccourse.datagen.provider.SoundEntry;
import net.kaupenjoe.mccourse.datagen.provider.SoundEntryBuilder;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.data.DataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.CompletableFuture;

public class ModSoundDefinitionProvider extends CustomFabricSoundProvider {
    public ModSoundDefinitionProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateSounds(SoundGenerator soundGenerator) {
        /*soundGenerator.add(ModSounds.METAL_DETECTOR_FOUND_ORE, false, ModSounds.METAL_DETECTOR_FOUND_ORE.getId().toShortTranslationKey(),
                SoundEntryBuilder.sound( MCCourseMod.mcId(ModSounds.METAL_DETECTOR_FOUND_ORE.getId().getPath()))
                        .build());*/
        generateCustomSoundWithSubtitles(soundGenerator, ModSounds.METAL_DETECTOR_FOUND_ORE, false);
        generateCustomSoundWithSubtitles(soundGenerator, ModSounds.PINK_GARNET_LAMP_BREAK, false);
        generateCustomSoundWithSubtitles(soundGenerator, ModSounds.PINK_GARNET_LAMP_STEP, false);
        generateCustomSoundWithSubtitles(soundGenerator, ModSounds.PINK_GARNET_LAMP_PLACE, false);
        generateCustomSoundWithSubtitles(soundGenerator, ModSounds.PINK_GARNET_LAMP_HIT, false);
        generateCustomSoundWithSubtitles(soundGenerator, ModSounds.PINK_GARNET_LAMP_FALL, false);
    }

    @SuppressWarnings("SameParameterValue")
    private void generateCustomSoundWithSubtitles(SoundGenerator soundGenerator, SoundEvent sound, boolean replace) {
        soundGenerator.add(sound, replace, "sounds." + sound.getId().toShortTranslationKey(),
                SoundEntryBuilder.sound( MCCourseMod.id(sound.getId().getPath()))
                        .build());
    }
}
