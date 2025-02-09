package net.tgh245.valyken.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;
import net.tgh245.valyken.item.custom.ChiselItem;
import net.tgh245.valyken.item.custom.FuelItem;
import net.tgh245.valyken.item.custom.OreDetector;

import java.util.List;

public class ModItems
{

    public static final DeferredRegister< Item > ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Valyken.MOD_ID);


    public static final RegistryObject< Item > ALEXANDRITE =
            ITEMS.register("alexandrite", ( ) -> new Item(new Item.Properties( )));
    public static final RegistryObject< Item > RAW_ALEXANDRITE =
            ITEMS.register("raw_alexandrite", ( ) -> new Item(new Item.Properties( )));
    public static final RegistryObject< Item > ORE_DETECTOR =
            ITEMS.register("ore_detector", ( ) -> new OreDetector(new Item.Properties( ).durability(100)));
    public static final RegistryObject< Item > CHISEL =
            ITEMS.register("chisel", ( ) -> new ChiselItem(new Item.Properties( ).durability(100)));

    public static final RegistryObject< Item > KOHLRABI =
            ITEMS.register("kohlrabi", ( ) -> new Item(new Item.Properties( ).food(ModFoodProperties.KOHLRABI)));

    public static final RegistryObject< Item > AURORA_ASHES =
            ITEMS.register("aurora_ashes", ( ) -> new FuelItem(new Item.Properties( ), 1200));

    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALEXANDRITE,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ALEXANDRITE, 1, -2.8F))
            )
    );

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = ITEMS.register("alexandrite_sword",
            () -> new SwordItem(ModToolTiers.ALEXANDRITE,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ALEXANDRITE, 3, -2.4F))
            )
    );

    public static final RegistryObject<Item> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe",
            () -> new AxeItem(ModToolTiers.ALEXANDRITE,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ALEXANDRITE, 5, -3.2F))
            )
    );

    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel",
            () -> new ShovelItem(ModToolTiers.ALEXANDRITE,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ALEXANDRITE, 1.5F, -3.0F))
            )
    );

    public static final RegistryObject<Item> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe",
            () -> new HoeItem(ModToolTiers.ALEXANDRITE,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.ALEXANDRITE, 0, -3.0F))
            )
    );

    public static final List< RegistryObject< Item > > items =
            List.of(RAW_ALEXANDRITE, ORE_DETECTOR, ALEXANDRITE, CHISEL, KOHLRABI, AURORA_ASHES);

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
