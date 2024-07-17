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
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

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

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GEM_EMPOWERING_STATION);

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

        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);

        //itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);

        registerDataTablet(itemModelGenerator,ModItems.DATA_TABLET);

        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);

        registerBow(itemModelGenerator, ModItems.PINK_GARNET_BOW);
    }
    // Took a look from ItemModelGenerator.registerArmor() method
    @SuppressWarnings("SameParameterValue")
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
//        System.out.println("TUTORIAL: " + id.toString() + " - " + textures.toString());

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

    @SuppressWarnings("SameParameterValue")
    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator, Block lampBlock) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(lampBlock, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(lampBlock, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector
                .accept(VariantsBlockStateSupplier.create(lampBlock)
                        .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED,
                                identifier2, identifier)));
    }

    @SuppressWarnings("SameParameterValue")
    private void registerBow(ItemModelGenerator itemModelGenerator, Item item) {
        if (item instanceof BowItem) {
//            String bowItemPath = getItemIdAsString(item);
            String bowItemPath = item.toString();

            Identifier bowItemIdentifier = MCCourseMod.id("item/" + bowItemPath);
//            Identifier identifier2 = Identifier.of(MCCourseMod.MOD_ID, "item/" + bowItemPath);

            Models.GENERATED.upload(bowItemIdentifier, TextureMap.layer0(bowItemIdentifier), itemModelGenerator.writer,
                    (id, textures) -> createBow(id, textures, item));

            Model model = new Model(Optional.of(MCCourseMod.id("item/" + bowItemPath)), Optional.empty(),
                TextureKey.LAYER0);

            // Pulling bow 0-1-2 models
            for(int i = 0 ; i < 3 ; i++){
                Identifier actualPullingBowIdentifier = MCCourseMod.id("item/" + bowItemPath + "_pulling_" + i);
                model.upload(actualPullingBowIdentifier, TextureMap.layer0(actualPullingBowIdentifier), itemModelGenerator.writer);
            }
        }
    }

    private JsonObject createBow(Identifier id, Map<TextureKey, Identifier> textures, Item item){
        JsonObject jsonObject = Models.GENERATED.createJson(id, textures);
        JsonObject displayNode = new JsonObject();

        String predicatePath = MCCourseMod.MOD_ID + ":" + "item/" + item.toString() + "_pulling_";
        JsonArray overridesJsonArray = new JsonArray();

        overridesJsonArray.add(addPredicateWithModel(predicatePath + 0, Map.of("pulling", 1f)));
        overridesJsonArray.add(addPredicateWithModel(predicatePath + 1, Map.of("pulling", 1f), Map.of("pull", 0.65f)));
        overridesJsonArray.add(addPredicateWithModel(predicatePath + 2, Map.of("pulling", 1f), Map.of("pull", 0.9f)));

        Vec3d rot1 = new Vec3d(0, 90, -25);
        Vec3d scale1 = new Vec3d(0.68, 0.68, 0.68);
        Vec3d trans1 = new Vec3d(1.13, 3.2, 1.13);

        Vec3d rot2 = new Vec3d( 0, -90, 25);
//        Vec3d scale2 = scale1;
        Vec3d trans2 = new Vec3d(1.13, 3.2, 1.13);

        Vec3d rot3 = new Vec3d( -80, -280, 40);
        Vec3d scale3 = new Vec3d(0.9, 0.9, 0.9);
        Vec3d trans3 = new Vec3d(-1, -2, 2.5);

        Vec3d rot4 = new Vec3d(-80, 260, -40);
//        Vec3d scale3 = new Vec3d(0.9, 0.9, 0.9);
        Vec3d trans4 = new Vec3d(-1, -2, 2.5);

        String fplh = ModelTransformationMode.FIRST_PERSON_LEFT_HAND.asString();
        String fprh = ModelTransformationMode.FIRST_PERSON_RIGHT_HAND.asString();
        String tplh = ModelTransformationMode.THIRD_PERSON_LEFT_HAND.asString();
        String tprh = ModelTransformationMode.THIRD_PERSON_RIGHT_HAND.asString();

        displayNode.add(fplh, addTransformationMode(
                Map.of("rotation", rot1), Map.of("scale", scale1), Map.of("translation", trans1)));
        displayNode.add(fprh, addTransformationMode(
                Map.of("rotation", rot2), Map.of("scale", scale1), Map.of("translation", trans2)));
        displayNode.add(tplh, addTransformationMode(
                Map.of("rotation", rot3), Map.of("scale", scale3), Map.of("translation", trans3)));
        displayNode.add(tprh, addTransformationMode(
                Map.of("rotation", rot4), Map.of("scale", scale3), Map.of("translation", trans4)));

        jsonObject.add("overrides", overridesJsonArray);
        jsonObject.add("display", displayNode);

        return jsonObject;
    }

    @SafeVarargs
    private JsonObject addPredicate(Map<String, Float>... predicateValues){
        JsonObject predicateContent = new JsonObject();
        JsonObject predicateNode = new JsonObject();

        for ( Map<String, Float> mapEntries : predicateValues){
            for(Map.Entry<String, Float>  entry : mapEntries.entrySet()){
                predicateContent.addProperty(entry.getKey(), entry.getValue());
            }
        }
        predicateNode.add("predicate", predicateContent);

        return predicateNode;
    }

    @SafeVarargs
    private JsonObject addPredicateWithModel(String modelName, Map<String, Float>... predicateValues){
        JsonObject predicateNode =  addPredicate(predicateValues);
        predicateNode.addProperty("model", modelName);

        return predicateNode;
    }

    @SafeVarargs
    private JsonObject addTransformationMode( Map<String, Vec3d>... predicateValues){
        JsonObject transformChildContent = new JsonObject();

        for ( Map<String, Vec3d> mapEntries : predicateValues){
            for(Map.Entry<String, Vec3d>  entry : mapEntries.entrySet()){
                transformChildContent.add(entry.getKey(), addJsonArray( entry.getValue()));
            }
        }

        return transformChildContent;
    }

    private JsonArray addJsonArray(Vec3d vec3d){
        JsonArray arrayElement = new JsonArray();
        arrayElement.add(vec3d.x);
        arrayElement.add(vec3d.y);
        arrayElement.add(vec3d.z);
        return arrayElement;
    }
}
