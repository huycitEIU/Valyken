package net.tgh245.valyken.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.tgh245.valyken.util.ModTags;
import org.jetbrains.annotations.NotNull;

public class OreDetector extends Item {
    public OreDetector(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide) {
            boolean found = false;
            BlockPos pos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            for (int i = 0; i < 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(pos.below(i));
                if (isOre(state)) {
                    found = true;
                    assert player != null;
                    player.sendSystemMessage(Component.literal(I18n.get(state.getBlock().getDescriptionId()) + " at y: " + pos.below(i).getY()));
                    break;
                }
            }

            if (!found) {
                assert player != null;
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
