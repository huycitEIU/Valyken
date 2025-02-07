package net.tgh245.valyken.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.block.ModBlocks;
import net.tgh245.valyken.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{

    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries)
    {
        super(Set.of( ), FeatureFlags.REGISTRY.allFlags( ), pRegistries);
    }

    @Override
    protected void generate( )
    {
        dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get( ));
        dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get( ));
        dropSelf(ModBlocks.MAGIC_BLOCK.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_STAIRS.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_SLAB.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_FENCE.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_FENCE_GATE.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_WALL.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_TRAP_DOOR.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_BUTTON.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_DOOR.get( ));
        dropSelf(ModBlocks.ALEXANDRITE_LAMP.get( ));
        this.add(ModBlocks.ALEXANDRITE_ORE.get( ), block -> createOreDrop(ModBlocks.ALEXANDRITE_ORE.get( ), ModItems.RAW_ALEXANDRITE.get( )));
        this.add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get( ), block -> createOreDrop(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get( ), ModItems.RAW_ALEXANDRITE.get( )));
    }


    @Override
    protected @NotNull Iterable< Block > getKnownBlocks( )
    {
        return ModBlocks.BLOCKS.getEntries( ).stream( ).map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item pItem, float minDrops, float maxDrops)
    {
        HolderLookup.RegistryLookup< Enchantment > registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
