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

    AnimationObject(double x0, double y0, double vx, double vy, double dimension, Color color) {
        m_x = x0;
        m_y = y0;
        m_vx = vx;
        m_vy = vy;
        m_dimension = dimension;
        mColor = color;

        setRadius(m_dimension);
        setTranslateX(m_x);
        setTranslateY(m_y);
        setFill(mColor);

        m_dt = 0.1;

        mTranslateTransition = new TranslateTransition();
        mTranslateTransition.setDuration(Duration.seconds(m_dt));

        mTranslateTransition.setNode(this);

        mTranslateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                calculate();
                mTranslateTransition.play();
            }
        });
    }

    public void play() {
        mTranslateTransition.play();
    }

    public void calculate() {

        double x0 = getTranslateX();
        double y0 = getTranslateY();

        if(x0>500)
            m_vx = -m_vx;

        if(y0>500)
            m_vy = -m_vy;

        if(x0<0)
            m_vx = -m_vx;

        if(y0<0)
            m_vy = -m_vy;

        double x1 = x0 + m_vx * m_dt;
        double y1 = y0 + m_vy * m_dt;

        //System.out.println("("+x0+","+y0+")->("+x1+","+y1+")");

        mTranslateTransition.setFromX(x0);
        mTranslateTransition.setFromY(y0);

        mTranslateTransition.setToX(x1);
        mTranslateTransition.setToY(y1);
    }
}
