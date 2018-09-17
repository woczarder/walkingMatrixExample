package com.harddrillstudio.walking.tiles;

import com.harddrillstudio.walking.assets.Assets;

public class WallTile extends Tile {


    protected WallTile(int id, boolean isBlocking) {
        super(id, isBlocking);
        this.texture = Assets.wallImage;
        this.body = "#";
    }

}
