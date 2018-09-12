package com.harddrillstudio.walking;

import com.harddrillstudio.walking.world.World;
import com.harddrillstudio.walking.world.map.WorldMap;

public class Handler {

    private String choice;
    private Game game;
    private World world;
    private WorldMap worldMap;


    public Handler(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
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
