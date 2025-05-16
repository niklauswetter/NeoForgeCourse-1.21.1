package net.niklauswetter.mccourse.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.niklauswetter.mccourse.MCCourseMod;
import net.niklauswetter.mccourse.item.custom.ChainsawItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCCourseMod.MOD_ID);

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL =
            ITEMS.registerItem("raw_black_opal",
                    Item::new, new Item.Properties());
    public static final DeferredItem<Item> CHAINSAW =
            ITEMS.registerItem("chainsaw",
                    ChainsawItem::new, new Item.Properties().durability(32));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
