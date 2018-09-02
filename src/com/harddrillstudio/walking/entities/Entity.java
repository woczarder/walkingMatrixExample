package com.harddrillstudio.walking.entities;

import com.harddrillstudio.walking.Handler;

public abstract class Entity {

    protected static Handler handler;

    protected int xPos, yPos;
    protected String body;


    protected abstract void move();
    public abstract void update();

    public Entity(Handler handler) {
        this.handler = handler;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
