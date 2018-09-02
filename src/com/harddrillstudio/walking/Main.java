package com.harddrillstudio.walking;

import java.util.Scanner;

public class Main {

    private int width = 8;
    private int height = 8;

    private int xPos, yPos;

    private String[][] tiles;



    private void render() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                System.out.print(tiles[y][x]);
            }
            System.out.println();
        }

        System.out.println("X:" + xPos + " Y: " + yPos);
    }


    private void update() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = ".";
            }
        }
        tiles[xPos][yPos] = "@";
    }


    private void movement(String input) {
        if (input.equals("j")) {xPos--;}
        if (input.equals("l")) {xPos++;}
        if (input.equals("i")) {yPos++;}
        if (input.equals("k")) {yPos--;}
    }


    public Main() {
        Scanner scanner = new Scanner(System.in);
        String choice;

        tiles = new String[width][height];

        xPos = 0;
        yPos = 0;

        while (true) {
            update();
            render();
            choice = scanner.nextLine();
            movement(choice);
        }
    }


    public static void main(String[] args) {
        new Main();
    }
}
