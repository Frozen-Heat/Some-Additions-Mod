package name.modid;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SomeAdditionsReferenceEnglishLangProvider extends FabricLanguageProvider {
	protected SomeAdditionsReferenceEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, "en_us", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
            translationBuilder.add("text.some_additions:rose_dye", "Rose Dye");
            translationBuilder.add("text.some_additions:spring_green_dye", "Spring Green Dye");
            translationBuilder.add("text.some_additions:rose_concrete", "Rose Concrete");
            translationBuilder.add("text.some_additions:spring_green_concrete", "Spring Green Concrete");
            translationBuilder.add("text.some_additions:rose_concrete_powder", "Rose Concrete Powder");
            translationBuilder.add("text.some_additions:spring_green_concrete_powder", "Spring Green Concrete Powder");
            translationBuilder.add("itemGroup.SomeAdditionsTab", "Some Additions Tab");
        }
    }

