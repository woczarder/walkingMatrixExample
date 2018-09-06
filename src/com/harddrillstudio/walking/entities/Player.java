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

        if (handler.getChoice().equals("j") || handler.getChoice().equals("4")) {xPos--;}
        if (handler.getChoice().equals("l") || handler.getChoice().equals("6")) {xPos++;}
        if (handler.getChoice().equals("i") || handler.getChoice().equals("8")) {yPos++;}
        if (handler.getChoice().equals("k") || handler.getChoice().equals("2")) {yPos--;}
    }


    @Override
    public void update() {
        move();
    }


}
