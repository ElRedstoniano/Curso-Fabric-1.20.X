package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.datagen.provider.CustomFabricSoundProvider;
import net.kaupenjoe.mccourse.datagen.provider.SoundEntryBuilder;
import net.kaupenjoe.mccourse.sound.ModSounds;
import net.minecraft.sound.SoundEvent;

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

        generateCustomMusicSound(soundGenerator, ModSounds.BAR_BRAWL);
    }
    // Took a look from https://github.com/FabricMC/fabric/pull/2759 and used the classes for custom sound datagen
    // https://discord.com/channels/507304429255393322/507982478276034570/1133787014240673822

    @SuppressWarnings("SameParameterValue")
    private void generateCustomSoundWithSubtitles(SoundGenerator soundGenerator, SoundEvent sound, boolean replace) {
        soundGenerator.add(sound, replace, "sounds." + sound.getId().toShortTranslationKey(),
                SoundEntryBuilder.sound( MCCourseMod.id(sound.getId().getPath()))
                        .build());
    }


    private void generateCustomMusicSound(SoundGenerator soundGenerator, SoundEvent sound) {
        soundGenerator.add(sound,
                SoundEntryBuilder.sound( MCCourseMod.id(sound.getId().getPath()))
                        .stream()
                        .build());
    }
}
