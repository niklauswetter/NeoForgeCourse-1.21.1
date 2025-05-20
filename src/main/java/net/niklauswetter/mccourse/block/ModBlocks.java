package net.niklauswetter.mccourse.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.niklauswetter.mccourse.MCCourseMod;
import net.niklauswetter.mccourse.block.custom.MagicBlock;
import net.niklauswetter.mccourse.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(MCCourseMod.MOD_ID);

    public static final DeferredBlock<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> RAW_BLACK_OPAL_BLOCK = registerBlock("raw_black_opal_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLACK_OPAL_DEEPSLATE_ORE = registerBlock("black_opal_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLACK_OPAL_END_ORE = registerBlock("black_opal_end_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLACK_OPAL_NETHER_ORE = registerBlock("black_opal_nether_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops().noLootTable()));

    public static final DeferredBlock<Block> BLACK_OPAL_STAIRS = registerBlock("black_opal_stairs",
            () -> new StairBlock(ModBlocks.BLACK_OPAL_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLACK_OPAL_SLAB = registerBlock("black_opal_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLACK_OPAL_PRESSURE_PLATE = registerBlock("black_opal_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON ,BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BLACK_OPAL_BUTTON = registerBlock("black_opal_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10, BlockBehaviour.Properties.of().strength(4F).requiresCorrectToolForDrops().noCollission()));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
