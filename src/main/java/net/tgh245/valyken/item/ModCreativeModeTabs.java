package net.tgh245.valyken.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Valyken.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEM_TAB =
            CREATIVE_MODE_TAB.register("alexandrite_item_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                            .title(Component.translatable(Valyken.MOD_ID + ".alexandrite_item_tab_title"))
                            .displayItems((itemDisplayParamenters, output) -> {
                                for (RegistryObject<Item> item: ModItems.items) {
                                    output.accept(item.get());
                                }
                            })
                            .build());
    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCK_TAB =
            CREATIVE_MODE_TAB.register("alexandrite_block_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                            .withTabsBefore(ALEXANDRITE_ITEM_TAB.getId())
                            .title(Component.translatable(Valyken.MOD_ID + ".alexandrite_block_tab_title"))
                            .displayItems((itemDisplayParameters, output) -> {

                                // display blocks in creative tab
                                for (RegistryObject<Block> block: ModBlocks.blocks) {
                                    output.accept(block.get());
                                }
                            })
                            .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
