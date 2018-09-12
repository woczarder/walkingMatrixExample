package com.harddrillstudio.walking.world.map;

public class Teleport {

    private WorldMap destination;

    public Teleport(WorldMap destination) {
        this.destination = destination;
    }



    public WorldMap getDestination() {
        return destination;
    }

    public void setDestination(WorldMap destination) {
        this.destination = destination;
    }
}
