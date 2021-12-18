package com.cursor.h2o;
import java.util.Scanner;
import java.util.concurrent.*;

public class Water {
    protected static final Semaphore oxygenBarrier = new Semaphore(1);
    protected static final Semaphore hydrogenBarrier = new Semaphore(2);
    private static void checkForCorrect(String inputStr) throws IllegalArgumentException {
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) != 'H' && inputStr.charAt(i) != 'O'){
                throw new IllegalArgumentException("Line must contain only 'H' or 'O'");
            }
        }
    }

    private static void releaseWater(String inputStr) {
        String[] characters = inputStr.split("");
        for (String val : characters) {
            if (val.equals("O")) {
                new Oxygen(oxygenBarrier, hydrogenBarrier).start();
            } else {
                new Thread(new Hydrogen(hydrogenBarrier, oxygenBarrier)).start();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Water.checkForCorrect(input);
        Water.releaseWater(input);

    }
}
