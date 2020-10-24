package info.vincent.vincmodop;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class WeaponsItemGroup extends ItemGroup {
    public WeaponsItemGroup() {
        super("Weapons");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.SAMPLEITEM);
    }
}
