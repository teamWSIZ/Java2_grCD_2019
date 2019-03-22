package com.javafx.BirdAnimation;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    FadeTransition mFadeTransition;
    TranslateTransition mTranslateTransition;

    Circle mCircle;

    @Override
    public void init() throws Exception {
        super.init();

        mFadeTransition = new FadeTransition();
        mFadeTransition.setDuration(Duration.seconds(2));

        mFadeTransition.setFromValue(0);
        mFadeTransition.setToValue(1.0);

        mTranslateTransition = new TranslateTransition();
        mTranslateTransition.setDuration(Duration.seconds(5));

        mCircle = new Circle();
        mCircle.setCenterX(0);
        mCircle.setCenterY(0);
        mCircle.setRadius(50);
        mCircle.setFill(Color.AZURE);

        //mFadeTransition.setNode(mCircle);
        mTranslateTransition.setNode(mCircle);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();

        Scene scene = new Scene(group,640,480);

        primaryStage.setScene(scene);
        primaryStage.show();

        group.getChildren().add(mCircle);


        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double x = event.getX();
                double y = event.getY();

                mTranslateTransition.setFromX(mCircle.getTranslateX());
                mTranslateTransition.setFromY(mCircle.getTranslateY());

                mTranslateTransition.setToX(x);
                mTranslateTransition.setToY(y);

                mTranslateTransition.stop();

                mTranslateTransition.play();

            }
        });

    }
}
