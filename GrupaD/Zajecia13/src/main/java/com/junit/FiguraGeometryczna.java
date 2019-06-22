package com.junit;

public abstract class FiguraGeometryczna {

    @FunctionalInterface
    protected interface FunkcjaPomocnicza{
        double oblicz(double a);
    }

    abstract public double obliczPole();
    abstract public double obliczObwod();

    abstract public double obliczObwod(FunkcjaPomocnicza funkcja,double a);

    private int mKolor = 0;

    public void setKolor(int kolor){
        mKolor = kolor;

    }

    public void wyswietlInfo(){
        System.out.println("Przykładowa informacja");

        setKolor(5);
    }
}
