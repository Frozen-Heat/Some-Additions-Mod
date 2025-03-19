package name.modid;


import net.minecraft.block.Block;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class SomeBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(SomeAdditions.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }



        return Registry.register(Registries.BLOCK, id, block);
    }
    public static final Block ROSE_CONCRETE = register(new Block(NewColoredBlock.Settings.create().mapColor(NewMapColors.ROSE).build().requiresTool().strength(1.8F)), "rose_concrete", true);
    public static final Block ROSE_CONCRETE_POWDER = register(new NewConcretePowderBlock(ROSE_CONCRETE, NewColoredBlock.Settings.create().mapColor(NewMapColors.ROSE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)), "rose_concrete_powder", true);
    public static final Block SPRING_GREEN_CONCRETE = register(new Block(NewColoredBlock.Settings.create().mapColor(NewMapColors.BRIGHT_TEAL).build().requiresTool().strength(1.8F)), "spring_green_concrete", true);
    public static final Block SPRING_GREEN_CONCRETE_POWDER = register(new NewConcretePowderBlock(SPRING_GREEN_CONCRETE, NewColoredBlock.Settings.create().mapColor(NewMapColors.BRIGHT_TEAL).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sounds(BlockSoundGroup.SAND)), "spring_green_concrete_powder", true);

    public static void initialize() {
    }
}

