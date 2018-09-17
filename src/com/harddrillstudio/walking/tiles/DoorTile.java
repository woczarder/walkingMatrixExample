package com.harddrillstudio.walking.tiles;

import com.harddrillstudio.walking.assets.Assets;

public class DoorTile extends Tile {

    protected DoorTile(int id, boolean isBlocking) {
        super(id, isBlocking);
        this.texture = Assets.doorImage;
        this.body = "<";
    }

}
