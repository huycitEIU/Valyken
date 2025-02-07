package net.tgh245.valyken.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.block.custom.AlexandriteLampBlock;
import net.tgh245.valyken.block.custom.MagicBlock;
import net.tgh245.valyken.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister< Block > BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Valyken.MOD_ID);


    public static final RegistryObject< Block > ALEXANDRITE_BLOCK = registryBlock("alexandrite_block", ( ) -> new Block(BlockBehaviour.Properties.of( )
            .strength(4f).requiresCorrectToolForDrops( ).sound(SoundType.AMETHYST))
    );
    public static final RegistryObject< StairBlock > ALEXANDRITE_STAIRS = registryBlock("alexandrite_stairs", ( ) -> new StairBlock(ModBlocks.ALEXANDRITE_BLOCK.get( )
                    .defaultBlockState( ), BlockBehaviour.Properties.of( ).strength(4f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< SlabBlock > ALEXANDRITE_SLAB = registryBlock("alexandrite_slab", ( ) -> new SlabBlock(BlockBehaviour.Properties.of( )
            .strength(4f).requiresCorrectToolForDrops( ))
    );
    public static final RegistryObject< PressurePlateBlock > ALEXANDRITE_PRESSURE_PLATE = registryBlock("alexandrite_pressure_plate", ( ) -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of( )
                    .strength(4f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< ButtonBlock > ALEXANDRITE_BUTTON = registryBlock("alexandrite_button", ( ) -> new ButtonBlock(BlockSetType.IRON, 1, BlockBehaviour.Properties.of( )
                    .strength(4f).requiresCorrectToolForDrops( ).noCollission( )
            )
    );
    public static final RegistryObject< FenceBlock > ALEXANDRITE_FENCE = registryBlock("alexandrite_fence", ( ) -> new FenceBlock(BlockBehaviour.Properties.of( )
            .strength(4f).requiresCorrectToolForDrops( ))
    );
    public static final RegistryObject< FenceGateBlock > ALEXANDRITE_FENCE_GATE = registryBlock("alexandrite_fence_gate", ( ) -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of( )
                    .strength(4f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< WallBlock > ALEXANDRITE_WALL = registryBlock("alexandrite_wall", ( ) -> new WallBlock(BlockBehaviour.Properties.of( )
            .strength(3f).requiresCorrectToolForDrops( ))
    );
    public static final RegistryObject< DoorBlock > ALEXANDRITE_DOOR = registryBlock("alexandrite_door", ( ) -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of( )
                    .strength(3f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< TrapDoorBlock > ALEXANDRITE_TRAP_DOOR = registryBlock("alexandrite_trap_door", ( ) -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of( )
                    .strength(3f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< Block > RAW_ALEXANDRITE_BLOCK = registryBlock("raw_alexandrite_block", ( ) -> new Block(BlockBehaviour.Properties.of( )
            .sound(SoundType.AMETHYST).strength(3f).requiresCorrectToolForDrops( ))
    );

    public static final RegistryObject< Block > ALEXANDRITE_ORE = registryBlock("alexandrite_ore", ( ) -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of( )
                    .strength(4f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< Block > ALEXANDRITE_DEEPSLATE_ORE = registryBlock("alexandrite_deepslate_ore", ( ) -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.of( )
                    .strength(5f).requiresCorrectToolForDrops( )
            )
    );
    public static final RegistryObject< Block > MAGIC_BLOCK = registryBlock("magic_block", ( ) -> new MagicBlock(BlockBehaviour.Properties.of( )
            .strength(2f).requiresCorrectToolForDrops( ))
    );

    public static final RegistryObject< Block > ALEXANDRITE_LAMP = registryBlock("alexandrite_lamp", ( ) -> new AlexandriteLampBlock(BlockBehaviour.Properties.of( )
            .strength(3f).requiresCorrectToolForDrops( )
            .lightLevel((state) -> state.getValue(AlexandriteLampBlock.CLICKED) ? 15 : 0))
    );

    private static < T extends Block > RegistryObject< T > registryBlock(final String name, Supplier< T > block)
    {
        RegistryObject< T > r = BLOCKS.register(name, block);
        registerBlockItem(name, r);
        return r;
    }

    private static < T extends Block > void registerBlockItem(final String name, final RegistryObject< T > block)
    {
        ModItems.ITEMS.register(name, ( ) -> new BlockItem(block.get( ), new Item.Properties( )));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}






















