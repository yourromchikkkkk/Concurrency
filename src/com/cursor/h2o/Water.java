package com.cursor.h2o;
import java.util.Scanner;
import java.util.concurrent.*;

public class Water {
    public static final CyclicBarrier barrier = new CyclicBarrier(3);

    private static void checkForCorrect(String inputStr) throws IllegalArgumentException {
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) != 'H' && inputStr.charAt(i) != 'O'){
                throw new IllegalArgumentException("Line must contain only 'H' or 'O'");
            }
        }
    }

    private static void releaseWater(String inputStr) {
        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == 'H') {
                new Thread(new Hydrogen()).start();
            } else if (inputStr.charAt(i) == 'O') {
                new Oxygen().start();
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
