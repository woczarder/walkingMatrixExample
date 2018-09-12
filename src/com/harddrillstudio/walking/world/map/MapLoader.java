package com.harddrillstudio.walking.world.map;

import com.harddrillstudio.walking.tiles.Tile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MapLoader {


    protected static WorldData getWorldData(String filename) throws IOException {
        File mapFile = new File("res/worlds/"+filename+"/"+filename+"data.txt");
        WorldData wd = new WorldData();

        BufferedReader br = new BufferedReader(new FileReader(mapFile));

        String[] allLines = new String[4];
        String tmpLn; int lineNo = 0;
        while ((tmpLn = br.readLine()) != null) {

            allLines[lineNo] = tmpLn;
            lineNo++;
        }

        wd.setWidth(    Integer.parseInt(allLines[0]) );
        wd.setHeight(   Integer.parseInt(allLines[1]) );
        wd.setSpawnX(   Integer.parseInt(allLines[2]) );
        wd.setSpawnY(   Integer.parseInt(allLines[3]) );

        return wd;
    }

    protected static Tile[][] loadMap(String filename, int width, int height) throws IOException {

        Tile[][] newMap = new Tile[width][height];

        String[] allLines  = getAllLines(filename, height);

        String[][] allChars = getAllChars(allLines, width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (allChars[y][x].equals("`")) {newMap[x][y] = Tile.voidTile;}
                if (allChars[y][x].equals("a")) {newMap[x][y] = Tile.floorTile;}
                if (allChars[y][x].equals("#")) {newMap[x][y] = Tile.wallTile;}
                if (allChars[y][x].equals("<")) {newMap[x][y] = Tile.doorTile;}

            }
        }

        return newMap;
    }


    private static String[][] getAllChars(String[] allLines, int width, int height) {
        String[][] allLetters = new String[height][width];

        for (int y = 0; y < height; y++) {
            String[] tmpArr = allLines[y].split("");
            for (int x = 0; x < width; x++) {
                allLetters[y][x] = tmpArr[x];
            }
        }
        return allLetters;
    }


    private static String[] getAllLines(String filename, int height) throws IOException {
        File mapFile = new File("res/worlds/"+filename+"/"+filename+".txt");
        String[] allLines = new String[height];

        BufferedReader br = new BufferedReader(new FileReader(mapFile));

        String tmpLn; int lineNo = 0;
        while ((tmpLn = br.readLine()) != null) {

            allLines[lineNo] = tmpLn;
            lineNo++;
        }

        return allLines;
    }

}
