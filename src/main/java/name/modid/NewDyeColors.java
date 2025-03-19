package name.modid;

import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.MapColor;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.ColorHelper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

@SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
public enum NewDyeColors implements StringIdentifiable {
    ROSE(1, "rose", 125560154, NewMapColors.ROSE, 16744490, 16763916),
    SPRING_GREEN(2, "spring_green", 3196836, NewMapColors.BRIGHT_TEAL, 6750204, 10092364);

    private static final IntFunction<NewDyeColors> BY_ID = ValueLists.createIdToValueFunction(NewDyeColors::getId, values(), ValueLists.OutOfBoundsHandling.ZERO);
    private static final Int2ObjectOpenHashMap BY_FIREWORK_COLOR = new Int2ObjectOpenHashMap<>((Map) Arrays.stream(values()).collect(Collectors.toMap((color) -> {
        return color.fireworkColor;
    }, (color) -> {
        return color;
    })));
    public static final StringIdentifiable.EnumCodec<NewDyeColors> CODEC = StringIdentifiable.createCodec(NewDyeColors::values);
    public static final PacketCodec<ByteBuf, NewDyeColors> PACKET_CODEC = PacketCodecs.indexed(BY_ID, NewDyeColors::getId);
    private final int id;
    private final String name;
    private final NewMapColors mapColor;
    private final int entityColor;
    private final int fireworkColor;
    private final int signColor;


    private NewDyeColors(final int id, final String name, final int entityColor, final NewMapColors mapColor, final int fireworkColor, final int signColor) {
        this.id = id;
        this.name = name;
        this.mapColor = mapColor;
        this.signColor = signColor;
        this.entityColor = ColorHelper.Argb.fullAlpha(entityColor);
        this.fireworkColor = fireworkColor;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getEntityColor() {
        return this.entityColor;
    }

    public int getFireworkColor() {
        return this.fireworkColor;
    }

    public int getSignColor() {
        return this.signColor;
    }

    public NewMapColors getMapColor() {
        return this.mapColor;
    }

    public static NewDyeColors byId(int id) {
        return (NewDyeColors) BY_ID.apply(id);
    }

    @Nullable
    @Contract("_,!null->!null;_,null->_")
    public static NewDyeColors byName(String name, @Nullable NewDyeColors defaultColor) {
        NewDyeColors dyeColor = (NewDyeColors)CODEC.byId(name);
        return dyeColor != null ? dyeColor : defaultColor;
    }

    @Nullable
    public static NewDyeColors byFireworkColor(int color) {
        return (NewDyeColors) BY_FIREWORK_COLOR.get(color);
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}