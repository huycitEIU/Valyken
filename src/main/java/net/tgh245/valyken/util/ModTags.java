package net.tgh245.valyken.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tgh245.valyken.Valyken;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> ORE_DETECTOR = tag("ore_detector");
        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = tag("needs_alexandrite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ALEXANDRITE_TOOL = tag("incorrect_for_alexandrite_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Valyken.MOD_ID, name));
        }
    }
}
