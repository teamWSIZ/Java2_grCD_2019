package com.junit;

public abstract class FiguraGeometryczna {

    abstract public double obliczPole();
    abstract public double obliczObwod();

    private int mKolor = 0;

    public void setKolor(int kolor){
        mKolor = kolor;

    }

    public void wyswietlInfo(){
        System.out.println("Przykładowa informacja");

        setKolor(5);
    }
}
