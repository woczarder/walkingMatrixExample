package com.harddrillstudio.walking.gfx;

import javafx.scene.image.Image;

import java.io.File;

public class ImageLoader {

    public static Image loadImage(String path) {
        return new Image(new File(path).toURI().toString());
    }

}
