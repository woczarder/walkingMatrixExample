package com.harddrillstudio.walking.entities;

import com.harddrillstudio.walking.Handler;
import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {

    protected static Handler handler;

    protected int xPos, yPos;
    protected String body;


    protected abstract void move();
    public abstract void update();
    public abstract void render(GraphicsContext gc);

    public Entity(Handler handler) {
        this.handler = handler;
    }





    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
