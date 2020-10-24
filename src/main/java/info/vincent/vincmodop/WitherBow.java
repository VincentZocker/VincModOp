package info.vincent.vincmodop;

import net.minecraft.item.BowItem;
import net.minecraft.item.Item;

public class WitherBow extends BowItem {
    public WitherBow() {
        super(new Item.Properties().group(ModItemGroups.weaponsItemGroup));
        setRegistryName(Reference.REIGSTRY_NAME_WITHERBOW_ITEM);
    }
}
