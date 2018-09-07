package com.harddrillstudio.walking.world;

public class WorldMap {

    private int width;
    private int height;

    private String[][] tiles;
    private MapMatrix mapMatrix;



    public WorldMap() {

        mapMatrix = new MapMatrix();
        width = mapMatrix.getWidth();
        height = mapMatrix.getHeight();

        tiles = new String[width][height];

    }


    public void update() {
        tiles = mapMatrix.getStringTiles();
    }


    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[x][y]);
            }
            System.out.println();
        }
    }


    public void setTile(int width, int height, String tile) {
        tiles[width][height] = tile;
    }


    public MapMatrix getMapMatrix() {
        return mapMatrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
