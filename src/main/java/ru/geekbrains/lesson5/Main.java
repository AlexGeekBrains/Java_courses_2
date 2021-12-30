package ru.geekbrains.lesson5;

import java.util.Arrays;

public class Main {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        ordinaryMethod();

        try {
            multithreadedMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void ordinaryMethod() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void multithreadedMethod() throws InterruptedException {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        float[] arrLeft = new float[HALF];
        float[] arrRight = new float[HALF];

        System.arraycopy(arr, 0, arrLeft, 0, HALF);
        System.arraycopy(arr, HALF, arrRight, 0, HALF);

        Thread threadLeft = new Thread(() -> {
            for (int i = 0; i < arrLeft.length; i++) {
                arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread threadRight = new Thread(() -> {
            for (int i = 0; i < arrRight.length; i++) {
                arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + (HALF + i) / 5) * Math.cos(0.2f + (HALF + i) / 5) * Math.cos(0.4f + (HALF + i) / 2));
            }
        });

        threadLeft.start();
        threadRight.start();
        threadLeft.join();
        threadRight.join();

        System.arraycopy(arrLeft, 0, arr, 0, arrLeft.length);
        System.arraycopy(arrRight, 0, arr, HALF, arrRight.length);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
