package net.tgh245.valyken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.block.ModBlocks;
import net.tgh245.valyken.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {


    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Valyken.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Blocks.ORE_DETECTOR)
                .addTag(Tags.Blocks.ORES);

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
        ;

        tag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
        ;

    }
}
