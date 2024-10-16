package net.danygames2014.spookysquashlands.listener;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Identifier;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {

    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        giantPumpkinFilling = getBlockTexture("block/giant_pumpkin_filling");

        giantPumpkinTopTopLeft = getBlockTexture("block/giant_pumpkin_top_top_left");
        giantPumpkinTopTopMiddle = getBlockTexture("block/giant_pumpkin_top_top_middle");
        giantPumpkinTopTopRight = getBlockTexture("block/giant_pumpkin_top_top_right");
        giantPumpkinTopMiddleLeft = getBlockTexture("block/giant_pumpkin_top_middle_left");
        giantPumpkinTopMiddleMiddle = getBlockTexture("block/giant_pumpkin_top_middle_middle");
        giantPumpkinTopMiddleRight = getBlockTexture("block/giant_pumpkin_top_middle_right");
        giantPumpkinTopBottomLeft = getBlockTexture("block/giant_pumpkin_top_bottom_left");
        giantPumpkinTopBottomMiddle = getBlockTexture("block/giant_pumpkin_top_bottom_middle");
        giantPumpkinTopBottomRight = getBlockTexture("block/giant_pumpkin_top_bottom_right");

        giantPumpkinMiddleTopLeft = getBlockTexture("block/giant_pumpkin_middle_top_left");
        giantPumpkinMiddleTopMiddle = getBlockTexture("block/giant_pumpkin_middle_top_middle");
        giantPumpkinMiddleTopRight = getBlockTexture("block/giant_pumpkin_middle_top_right");
        giantPumpkinMiddleMiddleLeft = getBlockTexture("block/giant_pumpkin_middle_middle_left");
        giantPumpkinMiddleMiddleMiddle = getBlockTexture("block/giant_pumpkin_middle_middle_middle");
        giantPumpkinMiddleMiddleRight = getBlockTexture("block/giant_pumpkin_middle_middle_right");
        giantPumpkinMiddleBottomLeft = getBlockTexture("block/giant_pumpkin_middle_bottom_left");
        giantPumpkinMiddleBottomMiddle = getBlockTexture("block/giant_pumpkin_middle_bottom_middle");
        giantPumpkinMiddleBottomRight = getBlockTexture("block/giant_pumpkin_middle_bottom_right");

        giantPumpkinBottomTopLeft = getBlockTexture("block/giant_pumpkin_bottom_top_left");
        giantPumpkinBottomTopMiddle = getBlockTexture("block/giant_pumpkin_bottom_top_middle");
        giantPumpkinBottomTopRight = getBlockTexture("block/giant_pumpkin_bottom_top_right");
        giantPumpkinBottomMiddleLeft = getBlockTexture("block/giant_pumpkin_bottom_middle_left");
        giantPumpkinBottomMiddleMiddle = getBlockTexture("block/giant_pumpkin_bottom_middle_middle");
        giantPumpkinBottomMiddleRight = getBlockTexture("block/giant_pumpkin_bottom_middle_right");
        giantPumpkinBottomBottomLeft = getBlockTexture("block/giant_pumpkin_bottom_bottom_left");
        giantPumpkinBottomBottomMiddle = getBlockTexture("block/giant_pumpkin_bottom_bottom_middle");
        giantPumpkinBottomBottomRight = getBlockTexture("block/giant_pumpkin_bottom_bottom_right");
    }

    public int getBlockTexture(String path) {
        return Atlases.getTerrain().addTexture(Identifier.of(NAMESPACE, path)).index;
    }

    public static int
            giantPumpkinFilling,

            giantPumpkinTopTopLeft,
            giantPumpkinTopTopMiddle,
            giantPumpkinTopTopRight,
            giantPumpkinTopMiddleLeft,
            giantPumpkinTopMiddleMiddle,
            giantPumpkinTopMiddleRight,
            giantPumpkinTopBottomLeft,
            giantPumpkinTopBottomMiddle,
            giantPumpkinTopBottomRight,

            giantPumpkinMiddleTopLeft,
            giantPumpkinMiddleTopMiddle,
            giantPumpkinMiddleTopRight,
            giantPumpkinMiddleMiddleLeft,
            giantPumpkinMiddleMiddleMiddle,
            giantPumpkinMiddleMiddleRight,
            giantPumpkinMiddleBottomLeft,
            giantPumpkinMiddleBottomMiddle,
            giantPumpkinMiddleBottomRight,

            giantPumpkinBottomTopLeft,
            giantPumpkinBottomTopMiddle,
            giantPumpkinBottomTopRight,
            giantPumpkinBottomMiddleLeft,
            giantPumpkinBottomMiddleMiddle,
            giantPumpkinBottomMiddleRight,
            giantPumpkinBottomBottomLeft,
            giantPumpkinBottomBottomMiddle,
            giantPumpkinBottomBottomRight;
}
