package com.harddrillstudio.walking.world;

import com.harddrillstudio.walking.assets.Tile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MapMatrix {

    private Tile[][] tiles;


    public MapMatrix() {
        tiles = new Tile[8][8];

        try {
            loadMap("world1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String[][] getStringTiles() {
        String[][] tiles2 = new String[8][8];

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (tiles[x][y].equals(Tile.voidTile)) {tiles2[x][y] = " ";}
                if (tiles[x][y].equals(Tile.floorTile)) {tiles2[x][y] = ".";}
                if (tiles[x][y].equals(Tile.wallTile)) {tiles2[x][y] = "#";}
            }
        }

        return tiles2;
    }


    private void loadMap(String filename) throws IOException {
        File mapFile = new File("res/"+filename);

        String[] tiles = new String[8];
        String[][] tiles2 = new String[8][8];

        BufferedReader br = new BufferedReader(new FileReader(mapFile));

        String tmpLn; int lineNo = 0;
        while ((tmpLn = br.readLine()) != null) {

            tiles[lineNo] = tmpLn;
            lineNo++;
        }

        for (int x = 0; x < 8; x++) {
//            System.out.println(tiles[x]);
            String[] tmpArr = tiles[x].split("");
            for (int y = 0; y < 8; y++) {
                tiles2[x][y] = tmpArr[y];
            }
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(tiles2[x][y]);
                if (tiles2[x][y].equals("`")) {this.tiles[x][y] = Tile.voidTile;}
                if (tiles2[x][y].equals("a")) {this.tiles[x][y] = Tile.floorTile;}
                if (tiles2[x][y].equals("#")) {this.tiles[x][y] = Tile.wallTile;}

            }
            System.out.println();
        }

    }

}
