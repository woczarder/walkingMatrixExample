package com.harddrillstudio.walking.world.map;

public class WorldData {

    private int width, height, spawnX, spawnY;


    protected void print() {
        System.out.println(String.format("width= %d height= %d X= %d Y= %d",width,height,spawnX,spawnY));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }
}
