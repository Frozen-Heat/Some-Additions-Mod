package name.modid.mixin;

import name.modid.NewDyeColors;
import net.minecraft.util.DyeColor;
import net.minecraft.block.MapColor;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(DyeColor.class)
public class DyeColorMixin {
    @Shadow
    @Mutable
    @Final
    private static DyeColor[] field_7953;

    @Invoker("<init>")
    public static DyeColor newColor(String realName, int ordId, int id, String name, int entityColor, MapColor mapColor, int fireworkColor, int signColor) {
        throw new AssertionError();
    }

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/util/DyeColor;field_7953:[Lnet/minecraft/util/DyeColor;", shift = At.Shift.AFTER))
    private static void addCustomColor(CallbackInfo ci) {
        List<DyeColor> dyeColors = new ArrayList<>(Arrays.asList(field_7953));
        DyeColor last = dyeColors.getLast();
        int i = 1;
        for (NewDyeColors color : NewDyeColors.values()) {
            dyeColors.add(newColor(color.name(), last.ordinal() + i, color.getId(), color.getName(), color.getEntityColor(), color.getMapColor(), color.getFireworkColor(), color.getSignColor()));
            i++;
        }
        field_7953 = dyeColors.toArray(new DyeColor[0]);
    }
}