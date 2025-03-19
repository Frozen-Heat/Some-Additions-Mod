package name.modid;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static name.modid.SomeBlocks.*;
import static name.modid.SomeItems.ROSE_DYE;
import static name.modid.SomeItems.SPRING_GREEN_DYE;

public class SomeAdditionsModelProvider extends FabricModelProvider {
    protected SomeAdditionsModelProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ROSE_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(SPRING_GREEN_CONCRETE);
        blockStateModelGenerator.registerSimpleCubeAll(ROSE_CONCRETE_POWDER);
        blockStateModelGenerator.registerSimpleCubeAll(SPRING_GREEN_CONCRETE_POWDER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ROSE_DYE, Models.GENERATED);
        itemModelGenerator.register(SPRING_GREEN_DYE, Models.GENERATED);
    }
}