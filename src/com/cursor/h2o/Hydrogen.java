package com.cursor.h2o;
import static com.cursor.h2o.Water.BARRIER;

public class Hydrogen implements Runnable{
    final private char element = 'H';

    private void releaseHydrogen() {
        System.out.print(element);
    }

    @Override
    public void run() {
        try {
            BARRIER.countDown();
            BARRIER.await();
            releaseHydrogen();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
