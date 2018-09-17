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

public class Game extends Application implements Runnable{

    private Group root;
    private Scene theScene;
    private Canvas canvas;

    private Handler handler;
    private World world;

    private Input input;

    private GraphicsContext graphicsContext;



    public Game() {
        Assets.init();
        input = new Input();

        handler = new Handler(this);
        world = new World(handler);
        handler.setWorld(world);
    }

    private void update() {
        //world.update();
    }

    private void render(GraphicsContext gc) {
        world.render(gc);
    }




    @Override
    public void start(Stage theStage) {

        initStage();
        theStage.setScene(theScene);

        canvas = new Canvas(800, 480);
        root.getChildren().add(canvas);

        // keyboard

        ArrayList<String> input = new ArrayList<>();

        theScene.setOnKeyPressed (Input.eventtt);

        theScene.setOnKeyTyped(
                new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
//                        Thread.suspend();
                    }
                }
        );
        theScene.setOnKeyReleased (
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });


        graphicsContext = canvas.getGraphicsContext2D();

        // loop
        new AnimationTimer() {

            @Override
            public void handle(long now) {

                graphicsContext.clearRect(0, 0, 800, 480);
                update();
                render(graphicsContext);

            }
        }.start();

        theStage.setTitle("Walking Matrix");
        theStage.show();
    }




    private void initStage() {
        root = new Group();
        theScene = new Scene(root);
    }


    @Override
    public void run() {

    }
}
