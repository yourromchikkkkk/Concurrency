package com.cursor.h2o;
import java.util.concurrent.CyclicBarrier;


public class Hydrogen implements Runnable{
    private CyclicBarrier barrier = Water.barrier;

    private void releaseHydrogen() {
        System.out.print('H');
    }

    @Override
    public void run() {
        try{
            barrier.await();
            releaseHydrogen();
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
