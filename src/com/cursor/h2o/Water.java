package com.cursor.h2o;
import java.util.concurrent.CountDownLatch;

public class Water {
    static final CountDownLatch BARRIER = new CountDownLatch(3); // parameter count = 3 (2 for hydrogens and 1 for oxygen)
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i ++) {
            Thread thread1 = new Thread(new Hydrogen());
            Thread thread2 = new Thread(new Hydrogen());
            Oxygen oxygenThread = new Oxygen();
            thread1.start();
            Thread.sleep(100);
            thread2.start();
            Thread.sleep(100);
            oxygenThread.start();
            Thread.sleep(100);
            System.out.println(" ");

        }
//        Hydrogen hydrogenThread1 = new Hydrogen();
//        Hydrogen hydrogenThread2 = new Hydrogen();
//        Oxygen oxygenThread = new Oxygen();
//        oxygenThread.start();
//        hydrogenThread1.start();
//        hydrogenThread2.start();

    }
}
