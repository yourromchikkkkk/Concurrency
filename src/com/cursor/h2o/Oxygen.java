package com.cursor.h2o;

import java.util.concurrent.CyclicBarrier;

import static com.cursor.h2o.Water.BARRIER;

public class Oxygen extends Thread{
    final private char element = 'O';
    private CyclicBarrier barrier = BARRIER;

    private void releaseOxygen() {
        System.out.print(element);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                releaseOxygen();
                barrier.await();
                Thread.sleep(3000);
                if (barrier.await() == 0) {
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println(e.getCause().toString());
            }
        }
    }
}
