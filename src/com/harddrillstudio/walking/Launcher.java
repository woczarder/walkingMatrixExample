package com.harddrillstudio.walking;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game();
        game.launch(args);

        Thread gameThread = new Thread(game);
        gameThread.start();
    }

}
