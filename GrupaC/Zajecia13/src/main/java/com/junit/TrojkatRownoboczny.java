package com.junit;

public class TrojkatRownoboczny extends FiguraGeometryczna{
    private double mA;

    public TrojkatRownoboczny(double a){
        mA = a;
    }

    @Override
    protected double obliczPole() {
        return Math.sqrt(3)/4*mA*mA;
    }

    @Override
    protected double obliczObwod() {
        return 3*mA;
    }
}
