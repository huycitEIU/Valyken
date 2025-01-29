package net.tgh245.valyken.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.tgh245.valyken.util.ModTags;

public class OreDetector extends Item {
    public OreDetector(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide) {
            boolean found = false;
            BlockPos pos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            for (int i = 0; i < 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(pos.below(i));
                if (isOre(state)) {
                    found = true;
                    player.sendSystemMessage(Component.literal(I18n.get(state.getBlock().getDescriptionId()) + " at y: " + pos.below(i).getY()));
                    break;
                }
            }

            if (!found) {
                player.sendSystemMessage(Component.literal(I18n.get("No ore!")));
            }

            pContext.getItemInHand().hurtAndBreak(1,
                    pContext.getPlayer(),
                    LivingEntity.getSlotForHand(pContext.getHand()));
        }

        return InteractionResult.SUCCESS;
    }

    private boolean isOre(BlockState state) {
        return state.is(ModTags.Blocks.ORE_DETECTOR);
    }

}
