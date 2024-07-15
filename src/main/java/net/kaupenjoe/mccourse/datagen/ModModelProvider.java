package net.kaupenjoe.mccourse.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.custom.CauliflowerCropBlock;
import net.kaupenjoe.mccourse.block.custom.PinkGarnetLampBlock;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        BlockStateModelGenerator.BlockTexturePool pinkGarnetTexturePool = blockStateModelGenerator
                .registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);

        /*blockStateModelGenerator.registerParentedItemModel(ModBlocks.PINK_GARNET_ORE,
                Identifier.of("minecraft", "block/" + Registries.BLOCK.getId(Blocks.COAL_ORE).getPath()));*/
        //Parented item model / will parent the actual item model to the desired new item model

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_PINK_GARNET_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);

        pinkGarnetTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        pinkGarnetTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
        pinkGarnetTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);
        pinkGarnetTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        pinkGarnetTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        pinkGarnetTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        pinkGarnetTexturePool.wall(ModBlocks.PINK_GARNET_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);

        registerCustomLamp(blockStateModelGenerator, ModBlocks.PINK_GARNET_LAMP_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.PETUNIA, ModBlocks.POTTED_PETUNIA,
                BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEAT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PAXEL, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_HELMET );
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.PINK_GARNET_BOOTS);
        //itemModelGenerator.reg
        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);

        //itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);

        registerDataTablet(itemModelGenerator,ModItems.DATA_TABLET);

        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);
    }
    // Took a look from ItemModelGenerator.registerArmor() method
    private void registerDataTablet(ItemModelGenerator itemModelGenerator, Item dataTablet) {
        //itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);
        Identifier identifier = Identifier.of(MCCourseMod.MOD_ID, "item/" + getItemIdAsString(dataTablet));
        Identifier identifier2 = Identifier.of(MCCourseMod.MOD_ID, "item/" +
                getItemIdAsString(dataTablet) + "_off");
        /*Model model = new Model(Optional.of(new Identifier("item/generated")), Optional.empty(),
                TextureKey.LAYER0);*/
        /*model*/Models.GENERATED.upload(identifier, TextureMap.layer0(identifier2), itemModelGenerator.writer,
                (id, textures) -> createDataTablet(id, textures, dataTablet/*, model*/));

        Identifier identifier3 = Identifier.of(MCCourseMod.MOD_ID, "item/" +
                getItemIdAsString(dataTablet) + "_on");
        Models.GENERATED.upload(identifier3, TextureMap.layer0(identifier), itemModelGenerator.writer);
    }
    private JsonObject createDataTablet(Identifier id, Map<TextureKey, Identifier> textures, Item item/*, Model model*/){
        System.out.println("TUTORIAL: " + id.toString() + " - " + textures.toString());

        JsonObject jsonObject = /*model*/Models.GENERATED.createJson(id, textures);
        JsonArray overridesJsonArray = new JsonArray();

        JsonObject jsonObject2 = new JsonObject();
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty( MCCourseMod.MOD_ID + ":on", 1);
        jsonObject2.add("predicate", jsonObject3);
        jsonObject2.addProperty("model", MCCourseMod.MOD_ID + ":item/" +
                getItemIdAsString(item) + "_on");
        overridesJsonArray.add(jsonObject2);

        jsonObject.add("overrides", overridesJsonArray);
        return jsonObject;
    }

    private String getItemIdAsString(Item item) {
        return Registries.ITEM.getId(item).getPath();
    }

    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator, Block lampBlock) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(lampBlock, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(lampBlock, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector
                .accept(VariantsBlockStateSupplier.create(lampBlock)
                        .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED,
                                identifier2, identifier)));
    }
}
