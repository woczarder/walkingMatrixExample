package com.harddrillstudio.walking.entities.actors;

import com.harddrillstudio.walking.Handler;
import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Enemy extends Actor {

    //int x = handler.getWorld().getEntityManager().getPlayer().getXPos();

    public Enemy(Handler handler) {
        super(handler);
        this.xPos = 3;
        this.yPos = 3;

        this.body = "t";
    }

    @Override
    protected void move() {
        Random rn = new Random();
        int move = rn.nextInt(4);

        switch (move) {
            case 0:
                if (canMoveRight)
                    xPos++;
                break;
            case 1:
                if (canMoveLeft)
                    xPos--;
                break;
            case 2:
                if (canMoveUp)
                    yPos--;
                break;
            case 3:
                if (canMoveDown)
                    yPos++;
                break;
        }
    }

    @Override
    public void update() {
        checkMovement();
        move();
    }

    @Override
    public void render(GraphicsContext gc) {

    }

}
