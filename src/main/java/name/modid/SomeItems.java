package name.modid;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.util.DyeColor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SomeItems {
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(SomeAdditions.MOD_ID, id);

        // Register the item.

        // Return the registered item!
        return Registry.register(Registries.ITEM, itemID, item);
    }
    public static final Item ROSE_DYE = register(new DyeItem(DyeColor.WHITE, new Item.Settings()), "rose_dye");
    public static final Item SPRING_GREEN_DYE = register(new DyeItem(DyeColor.WHITE, new Item.Settings()), "spring_green_dye");

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(SomeAdditions.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SomeItems.ROSE_DYE))
            .displayName(Text.translatable("itemGroup.SomeAdditionsTab"))
            .build();

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(SomeItems.ROSE_DYE);
            itemGroup.add(SomeItems.SPRING_GREEN_DYE);
        });

    }
}
