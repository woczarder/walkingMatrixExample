package com.harddrillstudio.walking.tiles;

import javafx.scene.image.Image;

public class FloorTile extends Tile {


    protected FloorTile(int id, boolean isBlocking) {
        super(id, isBlocking);

        this.body = ".";
    }

}
