package info.vincent.vincmodop;

import net.minecraft.util.IItemProvider;
import net.minecraftforge.registries.ObjectHolder;

public class ModItems {
    @ObjectHolder(Reference.MODID + ":" + Reference.REIGSTRY_NAME_SAMPLE_ITEM)
    public static SampleItem SAMPLEITEM = new SampleItem();

    @ObjectHolder(Reference.MODID + ":" + Reference.REIGSTRY_NAME_WITHERBOW_ITEM)
    public static WitherBow WITHERBOW = new WitherBow();

}
