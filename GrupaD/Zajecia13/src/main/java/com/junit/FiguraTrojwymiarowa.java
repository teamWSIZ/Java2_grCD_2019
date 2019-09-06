package com.junit;

public abstract class FiguraTrojwymiarowa {

    @FunctionalInterface
    protected interface FunkcjaPomocnicza{
        double oblicz(double a);
    }

    abstract public double obliczPole();
    abstract public double obliczObjetosc();

    abstract public double obliczObwod(FunkcjaPomocnicza funkcja,double a);



}
