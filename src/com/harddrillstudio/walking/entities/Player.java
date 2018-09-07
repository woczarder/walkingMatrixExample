package com.harddrillstudio.walking.entities;

import com.harddrillstudio.walking.Handler;

public class Player extends Entity {

    private boolean canMoveRight = false;
    private boolean canMoveLeft = false;
    private boolean canMoveUp = false;
    private boolean canMoveDown = false;

    public Player(Handler handler) {
        super(handler);
        this.xPos = 8;
        this.yPos = 1;
        this.body = "@";
    }


    @Override
    protected void move() {

        if (handler.getChoice() == null)
            return;

        moveLeft();
        moveRight();
        moveUp();
        moveDown();
    }


    @Override
    public void update() {
        System.out.println(xPos + " " + yPos);
        checkMovement();
        move();
    }

    private void moveRight() {
        if ( (handler.getChoice().equals("l") || handler.getChoice().equals("6") ) && canMoveRight )
            xPos++;
    }
    private void moveLeft() {
        if ( (handler.getChoice().equals("j") || handler.getChoice().equals("4") ) && canMoveLeft )
            xPos--;
    }
    private void moveUp() {
        if ( (handler.getChoice().equals("i") || handler.getChoice().equals("8") ) && canMoveUp )
            yPos--;
    }
    private void moveDown() {
        if ( (handler.getChoice().equals("k") || handler.getChoice().equals("2") ) && canMoveDown )
            yPos++;
    }

    private void checkMovement() {
        canMoveRight = checkMoveRight();
        canMoveLeft = checkMoveLeft();
        canMoveUp = checkMoveUp();
        canMoveDown = checkMoveDown();
    }

    private boolean checkMoveRight() {
        if (handler.getWorld() == null)
            return false;
        if (this.xPos == handler.getWorld().getWorldMap().getWidth() - 1)
            return false;
        if (handler.getWorld().getWorldMap().getMapMatrix().getTile(xPos + 1, yPos).isSolid)
            return false;
        return true;
    }

    private boolean checkMoveLeft() {
        if (handler.getWorld() == null)
            return false;
        if (this.xPos == 0)
            return false;
        if (handler.getWorld().getWorldMap().getMapMatrix().getTile(xPos - 1, yPos).isSolid)
            return false;
        return true;
    }

    private boolean checkMoveUp() {
        if (handler.getWorld() == null)
            return false;
        if (this.yPos == 0)
            return false;
        if (handler.getWorld().getWorldMap().getMapMatrix().getTile(xPos, yPos - 1).isSolid)
            return false;
        return true;
    }

    private boolean checkMoveDown() {
        if (handler.getWorld() == null)
            return false;
        if (this.yPos == handler.getWorld().getWorldMap().getHeight() - 1)
            return false;
        if (handler.getWorld().getWorldMap().getMapMatrix().getTile(xPos, yPos + 1).isSolid)
            return false;
        return true;
    }


}
