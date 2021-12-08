package com.cursor.h2o;
import java.util.concurrent.CyclicBarrier;

import static com.cursor.h2o.Water.BARRIER;

public class Hydrogen implements Runnable{
    final private char element = 'H';
    private CyclicBarrier barrier = BARRIER;

    private void releaseHydrogen() {
        System.out.print(element);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try{
                barrier.await();
                releaseHydrogen();
                Thread.sleep(100);
                if (barrier.await() == 0) {
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println(e.getCause().toString());
            }
        }
    }
}
