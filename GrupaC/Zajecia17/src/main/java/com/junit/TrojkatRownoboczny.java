package com.junit;

public class TrojkatRownoboczny extends FiguraGeometryczna {
    @FunctionalInterface
    public interface FunkcjaObliczajacaPole{
        double oblicz(double a);
    }

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

    protected double obliczPole(FunkcjaObliczajacaPole funkcja, double a){
        return funkcja.oblicz(a);
    }
}
