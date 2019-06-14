package com.junit;

public class Kwadrat extends FiguraGeometryczna{
    double mA;

    public Kwadrat(double a){
        mA = a;
    }

    @Override
    protected double obliczPole() {
        return mA*mA;
    }

    @Override
    protected double obliczObwod() {
        return 4*mA;
    }
}
