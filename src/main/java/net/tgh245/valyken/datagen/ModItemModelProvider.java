package net.tgh245.valyken.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
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
    }
}
