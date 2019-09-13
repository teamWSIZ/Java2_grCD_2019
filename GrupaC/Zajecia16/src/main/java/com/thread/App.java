/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thread;


class NewThread extends Thread {
    private double no;

    NewThread(double no) {
        this.no = no;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.no);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    static double mDane[] = new double[10];

    static void wyswietlDane() {
        System.out.print("[");

        for (int i = 0; i < mDane.length; i++) {
            System.out.print(mDane[i]);

            if (i < mDane.length - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }

    static synchronized void dodajDane(int no) {
        if (no >= 0 && no < mDane.length)
            mDane[no]++;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            final int j = i;

            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep((j + 1) * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    dodajDane(j);
                }
            });

            thread.start();
        }

        Thread wyswietlanie = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                wyswietlDane();
            }
        });

        wyswietlanie.start();

    }
}
