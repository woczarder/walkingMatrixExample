package com.harddrillstudio.walking;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Input {

    public static EventHandler eventtt = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            String code = event.getCode().toString();

        }
    };

}
