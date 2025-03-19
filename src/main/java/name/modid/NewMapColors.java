package name.modid;

import com.google.common.base.Preconditions;
import net.minecraft.block.MapColor;

public class NewMapColors {
    private static final NewMapColors[] COLORS = new NewMapColors[64];
    public static final NewMapColors CLEAR = new NewMapColors(0, 0);
    public static final NewMapColors ROSE = new NewMapColors(1, 13324296);
    public static final NewMapColors BRIGHT_TEAL = new NewMapColors(2, 1356933);
    //Isso é idêntico ao do vanilla, mas tive que botar aqui para eu não ter que fazer uma gambiarra com construtores no NewDyeColors
    public final int color;
    public final int id;

    private NewMapColors(int id, int color) {
        if (id >= 0 && id <= 63) {
            this.id = id;
            this.color = color;
            COLORS[id] = this;
        } else {
            throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
        }
    }

    public int getRenderColor(NewMapColors.Brightness brightness) {
        if (this == CLEAR) {
            return 0;
        } else {
            int i = brightness.brightness;
            int j = (this.color >> 16 & 255) * i / 255;
            int k = (this.color >> 8 & 255) * i / 255;
            int l = (this.color & 255) * i / 255;
            return -16777216 | l << 16 | k << 8 | j;
        }
    }

    public static NewMapColors get(int id) {
        Preconditions.checkPositionIndex(id, COLORS.length, "material id");
        return getUnchecked(id);
    }

    private static NewMapColors getUnchecked(int id) {
        NewMapColors NewMapColors = COLORS[id];
        return NewMapColors != null ? NewMapColors : CLEAR;
    }

    public static int getRenderColor(int colorByte) {
        int i = colorByte & 255;
        return getUnchecked(i >> 2).getRenderColor(NewMapColors.Brightness.get(i & 3));
    }

    public byte getRenderColorByte(NewMapColors.Brightness brightness) {
        return (byte)(this.id << 2 | brightness.id & 3);
    }

    public static enum Brightness {
        LOW(0, 180),
        NORMAL(1, 220),
        HIGH(2, 255),
        LOWEST(3, 135);

        private static final NewMapColors.Brightness[] VALUES = new NewMapColors.Brightness[]{LOW, NORMAL, HIGH, LOWEST};
        public final int id;
        public final int brightness;

        private Brightness(final int id, final int brightness) {
            this.id = id;
            this.brightness = brightness;
        }

        public static NewMapColors.Brightness validateAndGet(int id) {
            Preconditions.checkPositionIndex(id, VALUES.length, "brightness id");
            return get(id);
        }

        static NewMapColors.Brightness get(int id) {
            return VALUES[id];
        }
    }
}
