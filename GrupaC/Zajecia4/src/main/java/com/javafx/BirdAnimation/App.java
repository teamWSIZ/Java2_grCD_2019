package com.javafx.BirdAnimation;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;

public class App extends Application {
    FadeTransition mFadeTransition;
    TranslateTransition mTranslateTransition;

    ArrayList<ImageView> mKwiatki = new ArrayList<>();

    @Override
    public void init() throws Exception {
        super.init();

        mFadeTransition = new FadeTransition();
        mFadeTransition.setDuration(Duration.seconds(2));

        mFadeTransition.setFromValue(0);
        mFadeTransition.setToValue(1.0);

        mTranslateTransition = new TranslateTransition();
        mTranslateTransition.setDuration(Duration.seconds(5));

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();

        Scene scene = new Scene(group,640,480);

        primaryStage.setScene(scene);
        primaryStage.show();

        URL url = getClass().getResource("ptak.gif");
        Image image = new Image(url.toString());

        ImageView bird = new ImageView(image);
        bird.setFitWidth(100);
        bird.setFitHeight(100);

        bird.setPreserveRatio(true);

        group.getChildren().add(bird);

        mTranslateTransition.setNode(bird);


        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double x1 = event.getX();
                double y1 = event.getY();

                double x0 = bird.getTranslateX();
                double y0 = bird.getTranslateY();

                group.getChildren().removeAll(mKwiatki);
                group.getChildren().remove(bird);

                addFlower(x1,y1);

                group.getChildren().addAll(mKwiatki);
                group.getChildren().add(bird);


                if(x1>x0){
                    bird.setScaleX(1);
                }else{
                    bird.setScaleX(-1);
                }


                mTranslateTransition.setFromX(x0);
                mTranslateTransition.setFromY(y0);

                mTranslateTransition.setToX(x1);
                mTranslateTransition.setToY(y1);

                mTranslateTransition.stop();

                mTranslateTransition.play();

            }
        });

    }

    private void addFlower(double x, double y){

        URL url = getClass().getResource("kwiatek.png");
        Image image = new Image(url.toString());

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);

        imageView.setX(x);
        imageView.setY(y);

        imageView.setPreserveRatio(true);

        mKwiatki.add(imageView);
    }
}
