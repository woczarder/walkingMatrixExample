package com.harddrillstudio.walking.world;

import com.harddrillstudio.walking.assets.Tile;

import java.io.*;

public class MapMatrix {

    private Tile[][] tiles;
    private int width, height;
    private String filename;


    public MapMatrix() {

        filename = "world1";
        try {
            setDimensions(filename);

            tiles = new Tile[width][height];

            loadMap(filename);
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
            }
        }

        return tilesTmp;
    }


    private void loadMap(String filename) throws IOException {

        String[] allLines  = getAllLines(filename);

        String[][] allChars = getAllChars(allLines);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (allChars[y][x].equals("`")) {this.tiles[x][y] = Tile.voidTile;}
                if (allChars[y][x].equals("a")) {this.tiles[x][y] = Tile.floorTile;}
                if (allChars[y][x].equals("#")) {this.tiles[x][y] = Tile.wallTile;}

            }
        }

    }

    private String[] getAllLines(String filename) throws IOException {
        File mapFile = new File("res/"+filename+".txt");
        String[] allLines = new String[height];

        BufferedReader br = new BufferedReader(new FileReader(mapFile));

        String tmpLn; int lineNo = 0;
        while ((tmpLn = br.readLine()) != null) {

            allLines[lineNo] = tmpLn;
            lineNo++;
        }

        return allLines;
    }

    private String[][] getAllChars(String[] allLines) {
        String[][] allLetters = new String[height][width];

        for (int y = 0; y < height; y++) {
            String[] tmpArr = allLines[y].split("");
            for (int x = 0; x < width; x++) {
                allLetters[y][x] = tmpArr[x];
            }
        }
        return allLetters;
    }

    private void setDimensions(String filename) throws IOException {
        File mapFile = new File("res/"+filename+"data.txt");

        BufferedReader br = new BufferedReader(new FileReader(mapFile));

        String[] allLines = new String[2];
        String tmpLn; int lineNo = 0;
        while ((tmpLn = br.readLine()) != null) {

            allLines[lineNo] = tmpLn;
            lineNo++;
        }


        this.width = Integer.parseInt(allLines[0]);
        this.height = Integer.parseInt(allLines[1]);
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
