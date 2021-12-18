package com.cursor.h2o;

import java.util.concurrent.Semaphore;


public class Oxygen extends Thread{
    private Semaphore oxygenBarrier;
    private Semaphore hydrogenBarrier;

    public Oxygen(Semaphore barrier, Semaphore hydrogenBarrier) {
        this.oxygenBarrier = barrier;
        this.hydrogenBarrier = hydrogenBarrier;
    }

    private void releaseOxygen() {
        System.out.print('O');
    }

    @Override
    public void run() {
        try {
            oxygenBarrier.acquire();
            releaseOxygen();
            if (hydrogenBarrier.availablePermits() == 0 && oxygenBarrier.availablePermits() == 0) {
                hydrogenBarrier.release(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
