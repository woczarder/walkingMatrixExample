package com.harddrillstudio.walking.entities.actors;

import com.harddrillstudio.walking.Handler;
import com.harddrillstudio.walking.entities.Entity;

abstract class Actor extends Entity {

    boolean canMoveRight = false;
    boolean canMoveLeft = false;
    boolean canMoveUp = false;
    boolean canMoveDown = false;


    Actor(Handler handler) {
        super(handler);
    }



    void checkMovement() {
        canMoveRight = checkMoveRight();
        canMoveLeft = checkMoveLeft();
        canMoveUp = checkMoveUp();
        canMoveDown = checkMoveDown();
    }

    private boolean checkMoveRight() {
        if (handler.getWorld() == null)
            return false;
        if (this.xPos == handler.getWorldMap().getWidth() - 1)
            return false;
        return !handler.getWorldMap().getTile(this.xPos + 1, this.yPos).isBlocking;
    }

    private boolean checkMoveLeft() {
        if (handler.getWorld() == null)
            return false;
        if (this.xPos == 0)
            return false;
        return !handler.getWorldMap().getTile(this.xPos - 1, this.yPos).isBlocking;
    }

    private boolean checkMoveUp() {
        if (handler.getWorld() == null)
            return false;
        if (this.yPos == 0)
            return false;
        return !handler.getWorldMap().getTile(this.xPos, this.yPos - 1).isBlocking;
    }

    private boolean checkMoveDown() {
        if (handler.getWorld() == null)
            return false;
        if (this.yPos == handler.getWorldMap().getHeight() - 1)
            return false;
        return !handler.getWorldMap().getTile(this.xPos, this.yPos + 1).isBlocking;
    }
}
