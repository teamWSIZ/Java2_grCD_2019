/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.junit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Tag("przyklad")
    @Test
    public void przykladowyTest(){
        System.out.println("Przykladowy test");
    }

    @Tag("math")
    @Test
    public void pierwszyTest(){
        App app = new App();

        System.out.println("porównuje liczby 25 i wynik funkcji");
        assertEquals(20,app.dodaj(10,10));
    }

    @Tag("math")
    @Test
    public void testSzescianu(){
        FiguryGeometryczne figuryGeometryczne = new FiguryGeometryczne();

        assertEquals(125,figuryGeometryczne.objętoscSzescianu(5));
    }


}