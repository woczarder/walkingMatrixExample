package com.harddrillstudio.walking.world.map;

import com.harddrillstudio.walking.tiles.Tile;
import javafx.scene.canvas.GraphicsContext;

public class WorldMap extends MapMatrix {

    private String[][] stringTiles;



    public WorldMap(String name) {
        super(name);

        stringTiles = new String[width][height];


    }


    public void update() {
        stringTiles = getStringTiles();
    }



    public void render(GraphicsContext gc) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(gc, x*Tile.TILE_WIDTH, y*Tile.TILE_HEIGHT);
            }
        }
    }



    public void setTile(int width, int height, String tile) {
        stringTiles[width][height] = tile;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpawnX() {
        return worldData.getSpawnX();
    }

    public int getSpawnY() {
        return worldData.getSpawnY();
    }

}
