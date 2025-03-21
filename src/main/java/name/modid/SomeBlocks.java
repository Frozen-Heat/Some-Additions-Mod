package name.modid;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.*;

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

    //Eu desisto de tentar fazer novas cores de mapas pros blocos, essa porra é muito hardcoded, aqui estou só deixando meus pêsames ao meu tempo desperdiçado tentando.

    public static final Block ROSE_CONCRETE = register(new Block(AbstractBlock.Settings.copy(WHITE_CONCRETE).mapColor(NewDyeColors.ROSE.getMapColor())), "rose_concrete", true);
    public static final Block ROSE_WOOL = register(new Block((AbstractBlock.Settings.copy(WHITE_WOOL).mapColor(NewDyeColors.ROSE.getMapColor()))), "rose_wool", true);
    public static final Block ROSE_CONCRETE_POWDER = register(new ConcretePowderBlock(ROSE_CONCRETE, AbstractBlock.Settings.copy(WHITE_CONCRETE_POWDER).mapColor(NewDyeColors.ROSE.getMapColor())), "rose_concrete_powder", true);
    public static final Block SPRING_GREEN_CONCRETE = register(new Block(AbstractBlock.Settings.copy(WHITE_CONCRETE).mapColor(NewDyeColors.SPRING_GREEN.getMapColor())), "spring_green_concrete", true);
    public static final Block SPRING_GREEN_WOOL = register(new Block(AbstractBlock.Settings.copy(WHITE_WOOL).mapColor(NewDyeColors.SPRING_GREEN.getMapColor())), "spring_green_wool", true);
    public static final Block SPRING_GREEN_CONCRETE_POWDER = register(new ConcretePowderBlock(SPRING_GREEN_CONCRETE, AbstractBlock.Settings.copy(WHITE_CONCRETE_POWDER).mapColor(NewDyeColors.SPRING_GREEN.getMapColor())), "spring_green_concrete_powder", true);

    public static void initialize() {
    }
}

