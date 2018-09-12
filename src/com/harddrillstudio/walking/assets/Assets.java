package com.harddrillstudio.walking.assets;

import com.harddrillstudio.walking.gfx.ImageLoader;
import javafx.scene.image.Image;

import java.io.File;

public class Assets {

    public static Image voidImage;
    public static Image floorImage;

//    public static ArrayList<Image> textures;


    public static void init() {

        voidImage = ImageLoader.loadImage("res/textures/void.png");
        floorImage = ImageLoader.loadImage("res/textures/floor.png");

//        textures = new ArrayList<>();
//
//        textures.add(voidImage);
//        textures.add(floorImage);
    }

}
