package com.harddrillstudio.walking;

import com.harddrillstudio.walking.world.World;

public class Handler {

    private String choice;
    private Game game;
    private World world;


    public Handler(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
