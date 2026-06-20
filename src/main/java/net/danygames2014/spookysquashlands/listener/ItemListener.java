package net.danygames2014.spookysquashlands.listener;

import net.danygames2014.spookysquashlands.item.LazyAxeTemplate;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.item.tool.ToolLevel;
import net.modificationstation.stationapi.api.item.tool.ToolMaterialFactory;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;

public class ItemListener {
    public static LazyAxeTemplate swampAxe;

    @Entrypoint.Namespace
    public static Namespace NAMESPACE;

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        ToolLevel wooden = ToolMaterial.WOOD.getToolLevel();

        ToolMaterial spooky = ToolMaterialFactory.create("spooky", 1, 256, 2.0F, 3).toolLevel(wooden);

        swampAxe = new LazyAxeTemplate(Identifier.of(NAMESPACE, "swamp_axe"), spooky);
    }
}
