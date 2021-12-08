package com.cursor.h2o;
import java.util.concurrent.*;

public class Water {
    static final CyclicBarrier BARRIER = new CyclicBarrier(3); // parameter parties = 3 (2 for hydrogens and 1 for oxygen)
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Hydrogen()).start();
        new Thread(new Hydrogen()).start();
        new Oxygen().start();
//        Hydrogen hydrogenThread1 = new Hydrogen();
//        Hydrogen hydrogenThread2 = new Hydrogen();
//        Oxygen oxygenThread = new Oxygen();
//        oxygenThread.start();
//        hydrogenThread1.start();
//        hydrogenThread2.start();

    }
}
