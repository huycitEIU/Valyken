package net.tgh245.valyken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tgh245.valyken.Valyken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider
{


    public ModItemTagProvider(PackOutput packOutput, CompletableFuture< HolderLookup.Provider > completableFuture, CompletableFuture< TagLookup< Block > > lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(packOutput, completableFuture, lookupCompletableFuture, Valyken.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {

    }
}
