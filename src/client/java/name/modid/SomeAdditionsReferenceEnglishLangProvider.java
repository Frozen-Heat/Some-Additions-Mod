package name.modid;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SomeAdditionsReferenceEnglishLangProvider extends FabricLanguageProvider {
	protected SomeAdditionsReferenceEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            // Specifying en_us is optional, as it's the default language code
            super(dataOutput, "en_us", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
            translationBuilder.add("text.some_additions:rose_dye", "Rose Dye");
            translationBuilder.add("itemGroup.SomeAdditionsTab", "Some Additions Tab");

        }
    }

