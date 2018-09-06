package com.harddrillstudio.walking.assets;

public class WallTile extends Tile {


    protected WallTile(int id, boolean isSolid) {
        super(id, isSolid);

        this.body = "#";
    }

}
