package com.harddrillstudio.walking.tiles;

public class DoorTile extends Tile {

    protected DoorTile(int id, boolean isBlocking) {
        super(id, isBlocking);

        this.body = "<";
    }

}
