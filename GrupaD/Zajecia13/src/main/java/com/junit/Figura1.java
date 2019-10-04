package com.junit;

public class Figura1 extends FiguraGeometryczna{
    private double a;

    Figura1(double a){
        this.a = a;
    }

    @Override
    public double obliczPole() {
        return 0;
    }

    @Override
    public double obliczObwod() {
        return 0;
    }

    @Override
    public double obliczObwod(FunkcjaPomocnicza funkcja, double a) {
        return funkcja.oblicz(a);
    }
}
