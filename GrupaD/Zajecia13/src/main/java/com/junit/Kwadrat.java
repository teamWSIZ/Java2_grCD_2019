package com.junit;

public class Kwadrat extends FiguraGeometryczna {
    private double mBok;

    public Kwadrat(double bok){
        this.mBok = bok;
    }


    @Override
    public double obliczPole() {

        return mBok*mBok;
    }

    @Override
    public double obliczObwod() {
        return 4*mBok;
    }

    @Override
    public double obliczObwod(FunkcjaPomocnicza funkcja, double a) {
        return funkcja.oblicz(a);
    }
}
