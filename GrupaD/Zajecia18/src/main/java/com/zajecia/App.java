/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.zajecia;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

class AnimationObject extends Circle{
    private double m_x;
    private double m_y;
    private double m_dimension;
    private Color mColor;

    private TranslateTransition mTranslateTransition;

    boolean positive = true;

    AnimationObject(double x0, double y0, double dimension, Color color){
        m_x = x0;
        m_y = y0;
        m_dimension = dimension;
        mColor = color;

        setRadius(m_dimension);
        setCenterX(m_x);
        setCenterY(m_y);
        setFill(mColor);

        mTranslateTransition = new TranslateTransition();
        mTranslateTransition.setDuration(Duration.seconds(2));

        mTranslateTransition.setNode(this);

        mTranslateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Animacja zakonczona...");

                setDirection();
                mTranslateTransition.play();
            }
        });
    }

    public void play(){
        mTranslateTransition.play();
    }

    public void setDirection(){
        if(positive){
            mTranslateTransition.setFromX(0);
            mTranslateTransition.setFromX(0);
            mTranslateTransition.setToX(100);
            mTranslateTransition.setToY(100);
        }else{
            mTranslateTransition.setFromX(100);
            mTranslateTransition.setFromX(100);
            mTranslateTransition.setToX(0);
            mTranslateTransition.setToY(0);
        }

        positive = !positive;
    }
}

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group,500,500);

        AnimationObject object = new AnimationObject(0,0,20,Color.BLUE);



        Image image = new Image(getClass().getResource("grass.png").toString());
        group.getChildren().addAll(new ImageView(image),object);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
