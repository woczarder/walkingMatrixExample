package com.harddrillstudio.walking.assets;

public class VoidTile extends Tile {

    protected VoidTile(int id, boolean isSolid) {
        super(id, isSolid);

        this.body = " ";
    }

}
