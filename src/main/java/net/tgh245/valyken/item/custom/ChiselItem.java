package net.tgh245.valyken.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.tgh245.valyken.block.ModBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_BLOCKS =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.IRON_BLOCK, Blocks.DIAMOND_BLOCK,
                    Blocks.DIRT, ModBlocks.ALEXANDRITE_BLOCK.get()
            );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (CHISEL_BLOCKS.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(),
                        CHISEL_BLOCKS.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1,
                        pContext.getPlayer(),
                        LivingEntity.getSlotForHand(pContext.getHand()));

                level.playSound(null, pContext.getClickedPos(),
                        SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        }

        return InteractionResult.SUCCESS;
    }
}









