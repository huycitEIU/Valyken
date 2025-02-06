package net.tgh245.valyken.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.block.ModBlocks;
import net.tgh245.valyken.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Valyken.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> item: ModItems.items) {
            basicItem(item.get());
        }
        buttonItem(ModBlocks.ALEXANDRITE_BUTTON, ModBlocks.ALEXANDRITE_BLOCK);
        fenceItem(ModBlocks.ALEXANDRITE_FENCE, ModBlocks.ALEXANDRITE_BLOCK);
        wallItem(ModBlocks.ALEXANDRITE_WALL, ModBlocks.ALEXANDRITE_BLOCK);

        simpleBlockItem(ModBlocks.ALEXANDRITE_DOOR);
    }

    private void simpleBlockItem(RegistryObject< ? extends Block> item)
    {
        withExistingParent(item.getId( )
                .getPath( ), ResourceLocation.parse("item/generated")
        ).texture("layer0", ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID, "item/" + item.getId( ).getPath( )));
    }

    public void buttonItem(RegistryObject< ? extends Block > block, RegistryObject< Block> baseBlock)
    {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void fenceItem(RegistryObject< ? extends Block > block, RegistryObject< Block> baseBlock)
    {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject< ? extends Block > block, RegistryObject< Block> baseBlock)
    {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

}
