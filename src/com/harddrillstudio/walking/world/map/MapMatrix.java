package com.harddrillstudio.walking.world.map;

import com.harddrillstudio.walking.tiles.Tile;

import java.io.*;

public class MapMatrix {

    private Tile[][] tiles;
    protected int width, height;
    protected WorldData worldData;



    public MapMatrix(String filename) {
        try {
            worldData = MapLoader.getWorldData(filename);
            worldData.print();

            width = worldData.getWidth();
            height = worldData.getHeight();

            //tiles = new Tile[width][height];
            tiles = MapLoader.loadMap(filename, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String[][] getStringTiles() {
        String[][] tilesTmp = new String[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (tiles[x][y].equals(Tile.voidTile)) {tilesTmp[x][y] = "\u00a0";}
                if (tiles[x][y].equals(Tile.floorTile)) {tilesTmp[x][y] = ".";}
                if (tiles[x][y].equals(Tile.wallTile)) {tilesTmp[x][y] = "#";}
                if (tiles[x][y].equals(Tile.doorTile)) {tilesTmp[x][y] = "<";}
            }
        }

        return tilesTmp;
    }



    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
