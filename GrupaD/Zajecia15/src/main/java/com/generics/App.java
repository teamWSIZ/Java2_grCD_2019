/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.generics;

import java.util.ArrayList;

class Obiekt<T>{
    private T mWartosc;

    public T get(){
        return mWartosc;
    }

    public void set(T wartosc){
        mWartosc = wartosc;
    }
}

public class App {

    public static void main(String[] args) {
        ArrayList lista = new ArrayList();

        lista.add("Napis");
        lista.add(new Integer(10));

        Integer a = (Integer)lista.get(1);
        String s = (String)lista.get(0);

        ArrayList<Integer> liczby = new ArrayList<>();

        liczby.add(10);
        liczby.add(20);

        int b = liczby.get(0);
        int c = liczby.get(1);

        Obiekt<Integer> obiekt = new Obiekt<>();
        obiekt.set(10);

        int d = obiekt.get();


    }
}
