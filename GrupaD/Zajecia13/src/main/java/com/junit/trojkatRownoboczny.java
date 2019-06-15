package com.junit;

public class trojkatRownoboczny extends FiguraGeometryczna{
    private double mBok;

    public trojkatRownoboczny(double bok){
        mBok = bok;
    }

    @Override
    public double obliczPole() {
        return Math.sqrt(3)/4*mBok*mBok;
    }

    @Override
    public double obliczObwod() {
        return 3*mBok;
    }
}
