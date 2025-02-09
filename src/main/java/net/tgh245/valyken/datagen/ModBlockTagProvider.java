package net.tgh245.valyken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.block.ModBlocks;
import net.tgh245.valyken.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider
{


    public ModBlockTagProvider(PackOutput output, CompletableFuture< HolderLookup.Provider > lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, Valyken.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        tag(ModTags.Blocks.ORE_DETECTOR).addTag(Tags.Blocks.ORES).add(ModBlocks.ALEXANDRITE_ORE.get( ))
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get( ));

        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ALEXANDRITE_ORE.get( ))
                .add(ModBlocks.ALEXANDRITE_BLOCK.get( )).add(ModBlocks.ALEXANDRITE_DOOR.get( ))
                .add(ModBlocks.ALEXANDRITE_BUTTON.get( )).add(ModBlocks.ALEXANDRITE_FENCE.get( ))
                .add(ModBlocks.ALEXANDRITE_SLAB.get( )).add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get( ))
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get( )).add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get( ))
                .add(ModBlocks.ALEXANDRITE_TRAP_DOOR.get( )).add(ModBlocks.ALEXANDRITE_WALL.get( ))
                .add(ModBlocks.ALEXANDRITE_STAIRS.get( )).add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get( ))
                .add(ModBlocks.MAGIC_BLOCK.get( )).add(ModBlocks.ALEXANDRITE_LAMP.get( ));


        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.MAGIC_BLOCK.get( ));

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ALEXANDRITE_ORE.get( )).add(ModBlocks.ALEXANDRITE_BLOCK.get( ))
                .add(ModBlocks.ALEXANDRITE_DOOR.get( )).add(ModBlocks.ALEXANDRITE_BUTTON.get( ))
                .add(ModBlocks.ALEXANDRITE_FENCE.get( )).add(ModBlocks.ALEXANDRITE_SLAB.get( ))
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get( )).add(ModBlocks.ALEXANDRITE_FENCE_GATE.get( ))
                .add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get( )).add(ModBlocks.ALEXANDRITE_TRAP_DOOR.get( ))
                .add(ModBlocks.ALEXANDRITE_WALL.get( )).add(ModBlocks.ALEXANDRITE_STAIRS.get( ))
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get( )).add(ModBlocks.ALEXANDRITE_FENCE.get( ))
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get( )).add(ModBlocks.ALEXANDRITE_WALL.get( ))
                .add(ModBlocks.ALEXANDRITE_LAMP.get( ));

        tag(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL).addTag(BlockTags.NEEDS_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL);

        tag(BlockTags.FENCES).add(ModBlocks.ALEXANDRITE_FENCE.get( ));
        tag(BlockTags.FENCE_GATES).add(ModBlocks.ALEXANDRITE_FENCE_GATE.get( ));
        tag(BlockTags.WALLS).add(ModBlocks.ALEXANDRITE_WALL.get( ));
    }
}
