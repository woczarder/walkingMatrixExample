package com.harddrillstudio.walking.world;

import com.harddrillstudio.walking.Handler;
import com.harddrillstudio.walking.entities.EntityManager;

public class World {

    private int width = 8;
    private int height = 8;

    private String[][] tiles;

    private Handler handler;
    private EntityManager entityManager;
    private EntityDrawer entityDrawer;


    public World(Handler handler) {
        this.handler = handler;

        entityManager = new EntityManager(handler);
        entityDrawer = new EntityDrawer();
        tiles = new String[width][height];
    }


    public void update() {
        entityManager.update();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = ".";
            }
        }

        entityDrawer.updateTiles(this, entityManager.getEntities());
        //tiles[entityManager.getPlayer().getxPos()][entityManager.getPlayer().getyPos()] = "@";
    }


    public void render() {

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(tiles[x][height - 1 - y]);
            }
            System.out.println();
        }

        //System.out.println("X:" + player.getxPos() + " Y: " + player.getyPos());
    }


    public void setTile(int width, int height, String tile) {
        tiles[width][height] = tile;
    }
}
