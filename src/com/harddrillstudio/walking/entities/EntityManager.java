package com.harddrillstudio.walking.entities;

import com.harddrillstudio.walking.Handler;

import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entity> entities;

    Player player;



    public EntityManager(Handler handler) {
        player = new Player(handler);
        entities = new ArrayList<>();
        addEntity(player);
    }

    public void update() {
        player.update();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
