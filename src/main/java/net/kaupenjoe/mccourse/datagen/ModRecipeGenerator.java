package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {

    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('P', ModItems.PINK_GARNET)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE)) // unlocking recipe conditions
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_PINK_GARNET) + "_"));
        //Raw pink garnet crafting recipe (example)

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PINK_GARNET,
                RecipeCategory.MISC, ModBlocks.PINK_GARNET_BLOCK);
        //This line generates the pink_garnet.json and pink_garnet_block.json crafting recipes

        offerSmelting(exporter, List.of(
                ModItems.RAW_PINK_GARNET,
                ModBlocks.PINK_GARNET_ORE,
                ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                ModBlocks.NETHER_PINK_GARNET_ORE,
                ModBlocks.END_STONE_PINK_GARNET_ORE
                )
        , RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");

        offerBlasting(exporter, List.of(
                ModItems.RAW_PINK_GARNET,
                ModBlocks.PINK_GARNET_ORE,
                ModBlocks.DEEPSLATE_PINK_GARNET_ORE,
                ModBlocks.NETHER_PINK_GARNET_ORE,
                ModBlocks.END_STONE_PINK_GARNET_ORE
                )
        , RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100, "pink_garnet");

        // Take a look at VanillaReciperProvider
    }
}
