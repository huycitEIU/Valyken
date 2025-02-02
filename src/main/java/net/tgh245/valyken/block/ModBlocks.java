package net.tgh245.valyken.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.item.ModItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Valyken.MOD_ID);



    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registryBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registryBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.AMETHYST)
                    .strength(3f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registryBlock("alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
            ));

    public static final RegistryObject<Block> ALEXANDRITE_DEEPSLATE_ORE = registryBlock("alexandrite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
            ));


    public static final List<RegistryObject<Block>> blocks = List.of(ALEXANDRITE_BLOCK,
            RAW_ALEXANDRITE_BLOCK,
            ALEXANDRITE_ORE,
            ALEXANDRITE_DEEPSLATE_ORE
    );

    private static <T extends Block> RegistryObject<T> registryBlock(final String name, Supplier<T> block) {
        RegistryObject<T> r = BLOCKS.register(name, block);
        registerBlockItem(name, r);
        return r;
    }

    private static <T extends Block> void registerBlockItem(final String name, final RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}






















