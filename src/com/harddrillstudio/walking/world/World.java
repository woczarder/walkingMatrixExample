package com.harddrillstudio.walking.world;

import com.harddrillstudio.walking.Handler;
import com.harddrillstudio.walking.entities.actors.Enemy;
import com.harddrillstudio.walking.entities.EntityManager;
import com.harddrillstudio.walking.world.map.WorldMap;
import javafx.scene.canvas.GraphicsContext;

public class World {

    private WorldMap worldMap;
    private WorldMap worldMap2;
    private WorldMap worldMap3;

    private Handler handler;

    private EntityManager entityManager;
    private EntityDrawer entityDrawer;



    public World(Handler handler) {

        this.handler = handler;

        worldMap = new WorldMap("world1");
        worldMap2 = new WorldMap("world2");
        worldMap3 = new WorldMap("world3");

        handler.setWorldMap(worldMap3);

        entityManager = new EntityManager(handler);
        entityDrawer = new EntityDrawer();

        Enemy e = new Enemy(handler);
        entityManager.addEntity(e);
    }


    public void update() {

        if (handler.getWorldMap() != null) {

            entityManager.update();

            handler.getWorldMap().update();

            entityDrawer.updateTiles(handler.getWorldMap(), entityManager.getEntities());
        }

    }


    public void render(GraphicsContext gc) {
        gc.fillRect(0, 0, 100, 10);
        if (handler.getWorldMap() != null)
            handler.getWorldMap().render(gc);
    }



    public void swapWorldMap() {
        handler.setWorldMap(worldMap);
        this.entityManager.getPlayer().respawn();

        handler.getWorldMap().update();
        entityDrawer.updateTiles(handler.getWorldMap(), entityManager.getEntities());
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }
}
