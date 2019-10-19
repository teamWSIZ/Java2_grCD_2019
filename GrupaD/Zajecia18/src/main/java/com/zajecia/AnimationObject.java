package com.zajecia;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

class AnimationObject extends Circle {
    private double m_x;
    private double m_y;
    private double m_dimension;
    private Color mColor;
    private double m_dt;
    private double m_vx;
    private double m_vy;

    private TranslateTransition mTranslateTransition;

    boolean positive = true;

    AnimationObject(double x0, double y0, double m_vx, double m_vy, double dimension, Color color) {
        m_x = x0;
        m_y = y0;
        m_dimension = dimension;
        mColor = color;

        setRadius(m_dimension);
        setCenterX(m_x);
        setCenterY(m_y);
        setFill(mColor);

        m_dt = 0.1;

        mTranslateTransition = new TranslateTransition();
        mTranslateTransition.setDuration(Duration.seconds(m_dt));

        mTranslateTransition.setNode(this);

        mTranslateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Animacja zakonczona...");

                calculate();
                mTranslateTransition.play();
            }
        });
    }

    public void play() {
        mTranslateTransition.play();
    }

    public void calculate() {

        double x0 = m_x, y0 = m_y;
        double x1 = x0 + m_vx * m_dt;
        double y1 = y0 + m_vy * m_dt;
            
        mTranslateTransition.setFromX(x0);
        mTranslateTransition.setFromX(y0);
        mTranslateTransition.setToX(100);
        mTranslateTransition.setToY(100);
    }
}
