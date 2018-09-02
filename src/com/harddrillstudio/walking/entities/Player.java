package com.harddrillstudio.walking.entities;

import com.harddrillstudio.walking.Handler;

public class Player extends Entity {


    public Player(Handler handler) {
        super(handler);
        this.xPos = 0;
        this.yPos = 0;
        this.body = "@";
    }


    @Override
    protected void move() {

        if (handler.getChoice() == null)
            return;

        if (handler.getChoice().equals("j")) {xPos--;}
        if (handler.getChoice().equals("l")) {xPos++;}
        if (handler.getChoice().equals("i")) {yPos++;}
        if (handler.getChoice().equals("k")) {yPos--;}
    }


    @Override
    public void update() {
        move();
    }


}
