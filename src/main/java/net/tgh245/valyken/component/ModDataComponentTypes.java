package net.tgh245.valyken.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tgh245.valyken.Valyken;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes
{
    public static final DeferredRegister< DataComponentType<?> > DAT_COMPONENT_TYPES =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, Valyken.MOD_ID);

    public static final RegistryObject<DataComponentType< BlockPos >> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));

    private static <T>RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperato) {
        return DAT_COMPONENT_TYPES.register(name, () -> builderOperato.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus)
    {
        DAT_COMPONENT_TYPES.register(eventBus);
    }
}
