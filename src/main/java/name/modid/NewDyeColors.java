package name.modid;


import net.minecraft.block.MapColor;
import net.minecraft.util.DyeColor;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.ColorHelper;





public enum NewDyeColors implements StringIdentifiable {
    ROSE(16, "rose", 125560154, MapColor.DARK_CRIMSON, 16744490, 16763916),
    SPRING_GREEN(17, "spring_green", 3196836, MapColor.BRIGHT_TEAL, 6750204, 10092364);

    private final int id;
    private final String name;
    private final MapColor mapColor;
    private final int entityColor;
    private final int fireworkColor;
    private final int signColor;


     NewDyeColors(final int id, final String name, final int entityColor, final MapColor mapColor, final int fireworkColor, final int signColor) {
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

    public MapColor getMapColor() {
        return this.mapColor;
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

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }

    public DyeColor get() {
        return DyeColor.valueOf(this.name());
    }

    public String getSerializedName() {
        return this.name;
    }
}