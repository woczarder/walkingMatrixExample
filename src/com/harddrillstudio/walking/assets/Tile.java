package com.harddrillstudio.walking.assets;

public abstract class Tile {

    public final int ID;
    public boolean isSolid;
    public String body;


    public static Tile[] tiles = new Tile[256];
    public static Tile voidTile = new VoidTile(0, true);
    public static Tile floorTile = new FloorTile(1, false);
    public static Tile wallTile = new WallTile(2, true);



    protected Tile(int id, boolean isSolid) {
        ID = id;
        this.isSolid = isSolid;
    }

}
