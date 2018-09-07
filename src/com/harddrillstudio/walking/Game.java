package com.harddrillstudio.walking;

import com.harddrillstudio.walking.world.World;

import java.util.Scanner;

public class Game {

    private Handler handler;
    private World world;


    private void render() {
        world.render();
    }


    private void update() {
        world.update();
    }


    /*private void movement(String input) {
        if (input.equals("j")) {xPos--;}
        if (input.equals("l")) {xPos++;}
        if (input.equals("i")) {yPos++;}
        if (input.equals("k")) {yPos--;}
    }*/


    public Game() {
        initAssets();
        init();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            update();
            render();

            handler.setChoice(scanner.nextLine());
            System.out.println();
        }
    }



    private void initAssets() {

    }



    private void init() {
        handler = new Handler(this);
        world = new World(handler);
        handler.setWorld(world);
    }


    public static void main(String[] args) {
        new Game();
    }
}
