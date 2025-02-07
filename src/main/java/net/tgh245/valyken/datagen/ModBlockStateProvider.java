package net.tgh245.valyken.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.block.ModBlocks;
import net.tgh245.valyken.block.custom.AlexandriteLampBlock;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, Valyken.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels( )
    {
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);


        stairsBlock(ModBlocks.ALEXANDRITE_STAIRS.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));
        slabBlock(ModBlocks.ALEXANDRITE_SLAB.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));

        buttonBlock(ModBlocks.ALEXANDRITE_BUTTON.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));
        pressurePlateBlock(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));

        fenceBlock(ModBlocks.ALEXANDRITE_FENCE.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));
        fenceGateBlock(ModBlocks.ALEXANDRITE_FENCE_GATE.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));
        wallBlock(ModBlocks.ALEXANDRITE_WALL.get( ), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get( )));

        doorBlockWithRenderType(ModBlocks.ALEXANDRITE_DOOR.get( ), modLoc("block/alexandrite_door_bottom"), modLoc("block/alexandrite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ALEXANDRITE_TRAP_DOOR.get( ), modLoc("block/alexandrite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_TRAP_DOOR, "_bottom");

        customLamp();

    }

    private void customLamp( )
    {
        getVariantBuilder(ModBlocks.ALEXANDRITE_LAMP.get( )).forAllStates(state -> {
            if (state.getValue(AlexandriteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{
                        new ConfiguredModel(models( ).cubeAll("alexandrite_lamp_on", ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID, "block/alexandrite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{
                        new ConfiguredModel(models( ).cubeAll("alexandrite_lamp_off", ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID, "block/alexandrite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.ALEXANDRITE_LAMP.get( ), models( ).cubeAll("alexandrite_lamp_off",
                ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID, "block/alexandrite_lamp_off")));
    }

    private void blockWithItem(RegistryObject< ? extends Block > block)
    {
        simpleBlockWithItem(block.get( ), cubeAll(block.get( )));
    }

    private void blockItem(RegistryObject< ? extends Block > block)
    {
        simpleBlockItem(block.get( ), new ModelFile.UncheckedModelFile(
                "valyken:block/" + ForgeRegistries.BLOCKS.getKey(block.get( )).getPath( ))
        );
    }

    private void blockItem(RegistryObject< ? extends Block > block, String appendix)
    {
        simpleBlockItem(block.get( ), new ModelFile.UncheckedModelFile(
                "valyken:block/" + ForgeRegistries.BLOCKS.getKey(block.get( )).getPath( ) + appendix)
        );
    }
}
