package com.harddrillstudio.walking.world;

import com.harddrillstudio.walking.Handler;
import com.harddrillstudio.walking.entities.EntityManager;

public class World {

    private WorldMap worldMap;

    private Handler handler;

    private EntityManager entityManager;
    private EntityDrawer entityDrawer;



    public World(Handler handler) {

        this.handler = handler;

        entityManager = new EntityManager(handler);
        entityDrawer = new EntityDrawer();

        worldMap = new WorldMap();
    }


    public void update() {
        entityManager.update();

        worldMap.update();

        entityDrawer.updateTiles(worldMap, entityManager.getEntities());
        //tiles[entityManager.getPlayer().getxPos()][entityManager.getPlayer().getyPos()] = "@";
    }


    public void render() {

        worldMap.render();

        //System.out.println("X:" + player.getxPos() + " Y: " + player.getyPos());
    }



}
