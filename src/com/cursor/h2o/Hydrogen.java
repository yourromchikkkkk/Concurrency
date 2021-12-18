package com.cursor.h2o;
import java.util.concurrent.Semaphore;


public class Hydrogen implements Runnable{
    private Semaphore hydrogenBarrier;
    private Semaphore oxygenBarrier;

    public Hydrogen(Semaphore barrier, Semaphore oxygenBarrier) {
        this.hydrogenBarrier = barrier;
        this.oxygenBarrier = oxygenBarrier;
    }

    private void releaseHydrogen() {
        System.out.print('H');
    }

    @Override
    public void run() {
        try {
            hydrogenBarrier.acquire();
            if (hydrogenBarrier.availablePermits() == 0 && hydrogenBarrier.availablePermits() == 0) {
                releaseHydrogen();
                releaseHydrogen();
                oxygenBarrier.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
