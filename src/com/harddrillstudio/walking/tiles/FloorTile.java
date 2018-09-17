package com.harddrillstudio.walking.tiles;

import com.harddrillstudio.walking.assets.Assets;
import javafx.scene.image.Image;

public class FloorTile extends Tile {


    protected FloorTile(int id, boolean isBlocking) {
        super(id, isBlocking);
        this.texture = Assets.floorImage;
        this.body = ".";
    }

}
