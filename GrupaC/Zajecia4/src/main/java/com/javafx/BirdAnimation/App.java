package com.javafx.BirdAnimation;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
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

    ArrayList<Node> mKwiatki = new ArrayList<>();
    Node mPtaszek;

    Node mCurrentItem;

    @Override
    public void init() throws Exception {
        super.init();

        mFadeTransition = new FadeTransition();
        mFadeTransition.setDuration(Duration.seconds(2));

        mFadeTransition.setFromValue(0);
        mFadeTransition.setToValue(1.0);

        mTranslateTransition = new TranslateTransition();
        mTranslateTransition.setDuration(Duration.seconds(5));

        URL url = getClass().getResource("ptak.gif");
        Image image = new Image(url.toString());

        ImageView bird = new ImageView(image);
        bird.setFitWidth(100);
        bird.setFitHeight(100);

        bird.setPreserveRatio(true);

        mPtaszek = bird;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();

        Scene scene = new Scene(group,640,480);

        primaryStage.setScene(scene);
        primaryStage.show();

        group.getChildren().add(mPtaszek);

        mTranslateTransition.setNode(mPtaszek);

        mTranslateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                group.getChildren().removeAll(mKwiatki);
                group.getChildren().remove(mPtaszek);

                mKwiatki.remove(mCurrentItem);

                group.getChildren().addAll(mKwiatki);
                group.getChildren().add(mPtaszek);

                if(mKwiatki.size()>0){
                    mCurrentItem = mKwiatki.get(0);

                    double x0 = mPtaszek.getTranslateX();
                    double y0 = mPtaszek.getTranslateY();

                    double x1 = mCurrentItem.getTranslateX();
                    double y1 = mCurrentItem.getTranslateY();

                    mTranslateTransition.setFromX(x0);
                    mTranslateTransition.setFromY(y0);

                    mTranslateTransition.setToX(x1);
                    mTranslateTransition.setToY(y1);

                    mTranslateTransition.play();
                }

                System.out.println("Animacja zakończona");
            }
        });

        scene.setOnMouseClicked(event -> {
            double x1 = event.getX();
            double y1 = event.getY();

            double x0 = mPtaszek.getTranslateX();
            double y0 = mPtaszek.getTranslateY();

            group.getChildren().removeAll(mKwiatki);
            group.getChildren().remove(mPtaszek);

            if(mKwiatki.size()==0) {

                mCurrentItem = createFlower(x1, y1);
                mKwiatki.add(mCurrentItem);

                if (x1 > x0) {
                    mPtaszek.setScaleX(1);
                } else {
                    mPtaszek.setScaleX(-1);
                }

                mTranslateTransition.setFromX(x0);
                mTranslateTransition.setFromY(y0);

                mTranslateTransition.setToX(x1);
                mTranslateTransition.setToY(y1);

                mTranslateTransition.stop();

                mTranslateTransition.play();
            }else{
                mKwiatki.add(createFlower(x1, y1));
            }

            group.getChildren().addAll(mKwiatki);
            group.getChildren().add(mPtaszek);
        });


        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double x1 = event.getX();
                double y1 = event.getY();

                double x0 = mPtaszek.getTranslateX();
                double y0 = mPtaszek.getTranslateY();

                group.getChildren().removeAll(mKwiatki);
                group.getChildren().remove(mPtaszek);

                if(mKwiatki.size()==0) {

                    mCurrentItem = createFlower(x1, y1);
                    mKwiatki.add(mCurrentItem);

                    if (x1 > x0) {
                        mPtaszek.setScaleX(1);
                    } else {
                        mPtaszek.setScaleX(-1);
                    }

                    mTranslateTransition.setFromX(x0);
                    mTranslateTransition.setFromY(y0);

                    mTranslateTransition.setToX(x1);
                    mTranslateTransition.setToY(y1);

                    mTranslateTransition.stop();

                    mTranslateTransition.play();
                }else{
                    mKwiatki.add(createFlower(x1, y1));
                }

                group.getChildren().addAll(mKwiatki);
                group.getChildren().add(mPtaszek);

            }
        });

    }

    private ImageView createFlower(double x, double y){

        URL url = getClass().getResource("kwiatek.png");
        Image image = new Image(url.toString());

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50+Math.random()*50);
        imageView.setFitHeight(50+Math.random()*50);

        imageView.setX(x);
        imageView.setY(y);

        imageView.setPreserveRatio(true);

        return imageView;
    }
}
