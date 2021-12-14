package com.cursor.h2o;

import java.util.concurrent.CyclicBarrier;


public class Oxygen extends Thread{
    private CyclicBarrier barrier = Water.barrier;

    private void releaseOxygen() {
        System.out.print('O');
    }

    @Override
    public void run() {
        try{
            barrier.await();
            releaseOxygen();
            Thread.sleep(100);
            if (barrier.await() == 0) {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
