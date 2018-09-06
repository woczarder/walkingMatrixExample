package com.harddrillstudio.walking.world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WorldMap {

    private int width = 8;
    private int height = 8;

    private String[][] tiles;
    private MapMatrix mapMatrix;



    public WorldMap() {

        tiles = new String[width][height];
        mapMatrix = new MapMatrix();

        fillMapWithDots();
    }


    public void update() {
//        fillMapWithDots();
        tiles = mapMatrix.getStringTiles();
    }


    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[x][height - 1 - y]);
            }
            System.out.println();
        }
    }


    public void setTile(int width, int height, String tile) {
        tiles[width][height] = tile;
    }


    public void fillMapWithDots() {

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = ".";
            }
        }

    }


}
