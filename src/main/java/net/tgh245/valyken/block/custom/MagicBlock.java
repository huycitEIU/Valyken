package net.tgh245.valyken.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.tgh245.valyken.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class MagicBlock extends Block
{
    public MagicBlock(Properties properties)
    {
        super(properties);
    }


    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState pState, Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull BlockHitResult pHitResult)
    {
        pLevel.playSound(pPlayer, pPos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Entity pEntity)
    {
        if (pEntity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem( ).getItem( ) == ModItems.RAW_ALEXANDRITE.get( )) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem( ).getCount( )));
            }
            if (itemEntity.getItem( ).getItem( ) == Items.RABBIT_FOOT) {
                itemEntity.setItem(new ItemStack(Items.EMERALD, itemEntity.getItem( ).getCount( )));
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
