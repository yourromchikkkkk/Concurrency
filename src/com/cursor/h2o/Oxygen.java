package com.cursor.h2o;

import static com.cursor.h2o.Water.BARRIER;

public class Oxygen extends Thread{
    final private char element = 'O';

    private void releaseOxygen() {
        System.out.print(element);
    }

    @Override
    public void run() {
        try {
            BARRIER.countDown(); // parameter - 1
            BARRIER.await(); // thread is locked till count != 0
            releaseOxygen();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
