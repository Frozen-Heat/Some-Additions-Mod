package name.modid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;

public class NewConcretePowderBlock extends ConcretePowderBlock {
    public final NewMapColors mapColor;

    public NewConcretePowderBlock(Block hardened, NewColoredBlock.Settings settings) {
        super(hardened, settings.build());
        this.mapColor = settings.getMapColor();
    }
}
