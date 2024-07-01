package net.kaupenjoe.mccourse;

import net.fabricmc.api.ModInitializer;

import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCCourseMod implements ModInitializer {
	public static final String MOD_ID = "mccourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path){
		return  Identifier.of(MOD_ID, path);
	}
}