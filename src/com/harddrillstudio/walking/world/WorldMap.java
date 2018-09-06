package com.harddrillstudio.walking.world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WorldMap {

    private int width = 8;
    private int height = 8;

    private String[][] tiles;




    public WorldMap() {

        tiles = new String[width][height];

        fillMapWithDots();

        try {
            loadMap("world1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update() {
        fillMapWithDots();
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


    private void loadMap(String filename) throws IOException {
        File mapFile = new File("res/"+filename);

        int longestLineLength = 0;

        BufferedReader br = new BufferedReader(new FileReader(mapFile));

        String tmpLn;
        while ((tmpLn = br.readLine()) != null) {
            System.out.println(tmpLn);

            if (longestLineLength < tmpLn.length())
                longestLineLength = tmpLn.length();
        }

        System.out.println("Longest line: " + longestLineLength);
    }

}
