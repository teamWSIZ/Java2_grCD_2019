package com.zajecia;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class genV {
    static ArrayList<Color> colors = new ArrayList<>();

    static double getX() {
        return Math.random() * 250;
    }

    static double getY() {
        return Math.random() * 250;
    }

    static double getSize() {
        return Math.random() * 20 + 10;
    }

    static double getVx() {
        return Math.random()*50+10;
    }

    static double getVy() {
        return Math.random()*50+10;
    }

    static Color getColor(){
        return Color.color(Math.random(),Math.random(),Math.random());
    }
}
