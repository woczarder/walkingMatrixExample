package com.harddrillstudio.walking.tiles;

import com.harddrillstudio.walking.assets.Assets;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Tile {

    public static final int TILEWIDTH = 48, TILEHEIGHT = 48;

    private final int ID;
    public boolean isBlocking;
    String body;
    Image texture;

    public static Tile voidTile = new VoidTile(0, true);
    public static Tile floorTile = new FloorTile(1, false);
    public static Tile wallTile = new WallTile(2, true);
    public static Tile doorTile = new WallTile(3, false);


    Tile(int id, boolean isBlocking) {
        ID = id;
        this.isBlocking = isBlocking;
        this.texture = Assets.floorImage;
    }

    public void render(GraphicsContext gc, int x, int y) {
        gc.drawImage(this.texture, x, y, TILEWIDTH, TILEHEIGHT);
    }
}