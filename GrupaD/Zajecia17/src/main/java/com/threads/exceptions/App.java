/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.threads.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        int x = 10;
        int y = 10;

        Scanner scanner = new Scanner(System.in);
        String data = "";

        while (true) {
            try {
                data = scanner.next();
                System.out.println("Wprowadzono: " + data);
            }catch(Exception e){

            }

        }


/*
        try {
            double result = divide(x,y);
            System.out.println(x + "/" + y + " = " + result);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
        */

    }

    private static double divide(int x,int y){
        if(y==0)
            throw new ArithmeticException("y nie może wynosić zero");

        return x/y;
    }
}