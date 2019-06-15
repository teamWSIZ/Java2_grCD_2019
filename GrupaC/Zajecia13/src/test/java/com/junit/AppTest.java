/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void pierwszyTest(){
           System.out.println("pierwszy test");
    }

    @Test
    void sprawdzRownanie(){
        assertEquals(10,5+5);
    }

    @Test
    public void sprawdzFunkcjeDodajLiczby(){
        App app = new App();

        assertEquals(50,app.dodajLiczby(20,30));
    }

    @Tag("Kwadrat")
    @Tag("Figury")
    @Test
    public void kwadrat(){

        FiguraGeometryczna figura = new Kwadrat(10);

        assertEquals(100,figura.obliczPole());
        assertEquals(40,figura.obliczObwod());
    }

    @Tag("Trojkat")
    @Tag("Figury")
    @Test
    public void trojkat(){

        FiguraGeometryczna figura = new TrojkatRownoboczny(10);

        double poleOczekiwane = 43.30127018922193233800;
        double poleObliczone = figura.obliczPole();

        double roznicaPol = poleOczekiwane-poleObliczone;


        assertTrue(Math.abs(roznicaPol)<0.0000001);
        System.out.println("Różnica pól: "+roznicaPol);

        assertEquals(30,figura.obliczObwod());

    }

}
