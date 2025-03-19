package name.modid;


import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;


import java.util.function.Function;

public class NewColoredBlock {
    public static class Settings {
        private final AbstractBlock.Settings vanillaSettings;
        private Function<BlockState, NewMapColors> mapColorProvider = (state) -> NewMapColors.CLEAR;

        private Settings(AbstractBlock.Settings vanillaSettings) {
            this.vanillaSettings = vanillaSettings;
        }

        public static Settings create() {
            return new Settings(AbstractBlock.Settings.create());
        }

        public Settings mapColor(NewMapColors color) {
            this.mapColorProvider = (state) -> color;
            return this;
        }

        public Settings strength(float hardness) {
            this.vanillaSettings.strength(hardness);
            return this;
        }

        public Settings strength(float hardness, float resistance) {
            this.vanillaSettings.strength(hardness, resistance);
            return this;
        }

        public Settings requiresTool() {
            this.vanillaSettings.requiresTool();
            return this;
        }

        public NewMapColors getMapColor() {
            return this.mapColorProvider.apply(null);
        }

        public Settings sounds(BlockSoundGroup soundGroup) {
            this.vanillaSettings.sounds(soundGroup);
            return this;
        }

        public Settings instrument(NoteBlockInstrument instrument) {
            this.vanillaSettings.instrument(instrument);
            return this;
        }

        public AbstractBlock.Settings build() {
            return this.vanillaSettings;
        }
    }
}
