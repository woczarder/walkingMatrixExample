package com.harddrillstudio.walking.assets;

public class FloorTile extends Tile {


    protected FloorTile(int id, boolean isSolid) {
        super(id, isSolid);

        this.body = ".";
    }

}
