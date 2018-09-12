package com.harddrillstudio.walking.tiles;

public class WallTile extends Tile {


    protected WallTile(int id, boolean isBlocking) {
        super(id, isBlocking);

        this.body = "#";
    }

}
