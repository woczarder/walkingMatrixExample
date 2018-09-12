package com.harddrillstudio.walking.entities.actors;

import com.harddrillstudio.walking.Handler;
import com.harddrillstudio.walking.tiles.Tile;
import javafx.scene.canvas.GraphicsContext;

public class Player extends Actor {


    public Player(Handler handler) {
        super(handler);
        this.xPos = handler.getWorldMap().getSpawnX();
        this.yPos = handler.getWorldMap().getSpawnY();
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
        teleport();
    }



    @Override
    public void update() {
        System.out.println("x = " + xPos + "  y = " + yPos);
        checkMovement();
        move();
    }

    @Override
    public void render(GraphicsContext gc) {

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

    private void teleport() {
        if ( handler.getChoice().equals("<") && handler.getWorldMap().getTile(xPos, yPos).equals(Tile.doorTile)) {
            handler.getWorld().swapWorldMap();
        }
    }


    public void respawn() {
        this.xPos = handler.getWorldMap().getSpawnX();
        this.yPos = handler.getWorldMap().getSpawnY();
    }


}
