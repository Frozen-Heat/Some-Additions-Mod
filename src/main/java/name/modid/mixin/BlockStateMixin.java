package name.modid.mixin;

import name.modid.CustomColoredBlock;
import name.modid.NewColoredBlock;
import name.modid.NewMapColors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class BlockStateMixin {
    @Inject(
            method = "getMapColor",
            at = @At("HEAD"),
            cancellable = true
    )
    private void overrideMapColor(BlockView world, BlockPos pos, CallbackInfoReturnable<MapColor> cir) {
        BlockState state = (BlockState)(Object)this;
        if (state.getBlock() instanceof CustomColoredBlock customBlock) {
            NewMapColors color = customBlock.getCustomMapColor();
        }
    }
}
