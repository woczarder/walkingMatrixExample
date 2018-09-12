package com.harddrillstudio.walking;


import com.harddrillstudio.walking.assets.Assets;
import com.harddrillstudio.walking.world.World;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Game extends Application {

    private Group root;
    private Scene theScene;
    private Canvas canvas;

    private Handler handler;
    private World world;



    public Game() {
        initAssets();
        handler = new Handler(this);
        world = new World(handler);
        handler.setWorld(world);
    }

    private void update() {
        //world.update();
    }

    private void render(GraphicsContext gc) {
//        gc.setStroke(Color.BLACK);
//        gc.fillRect(0, 0, 100, 100);
        world.render(gc);
    }


    @Override
    public void start(Stage theStage) throws Exception {

        initStage();
        theStage.setScene(theScene);

        canvas = new Canvas(800, 480);
        root.getChildren().add(canvas);

        // keyboard

        ArrayList<String> input = new ArrayList<String>();
        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        String code = event.getCode().toString();

                        if (!input.contains(code))
                            input.add(code);
                    }
                }
        );
        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });


        GraphicsContext gc = canvas.getGraphicsContext2D();

        // loop
        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                double t = (now - startNanoTime) / 1000000000.0;

                gc.clearRect(0, 0, 800, 480);
                update();
                render(gc);


                double x = 250 + 200 * Math.cos(t);
                double y = 250 + 200 * Math.sin(t);
                gc.fillText("IM FUKEN GAY!", x, y);
            }
        }.start();

        theStage.setTitle("Walking Matrix");
        theStage.show();
    }

    private void initStage() {
        root = new Group();
        theScene = new Scene(root);
    }

    private void initAssets() {
        Assets.init();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
