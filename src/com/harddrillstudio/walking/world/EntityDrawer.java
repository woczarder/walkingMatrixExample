package com.harddrillstudio.walking.world;

import com.harddrillstudio.walking.entities.Entity;

import java.util.ArrayList;

public class EntityDrawer {

    public void updateTiles(World world, ArrayList<Entity> entities) {

        int x, y;
        String b;
        for (Entity e: entities) {
            x = e.getxPos();
            y = e.getyPos();
            b = e.getBody();

            world.setTile(x, y, b);
        }

    }
}
