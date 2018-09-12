package com.harddrillstudio.walking.tiles;

public class VoidTile extends Tile {

    protected VoidTile(int id, boolean isBlocking) {
        super(id, isBlocking);

        this.body = " ";
    }

}
