package com.company;

public class Daemon implements Runnable {

    public static void start() {
        Thread thread = new Thread(new Daemon());

        thread.setDaemon(true);
        thread.start();
    }

    public void run() {

        long memoryUsed = getMemoryUsed();
        Runtime runtime = getRuntime();
        System.out.println("Memory used :" + memoryUsed + " MB");

        while (true) {
            Runtime runtime1 = getRuntime();
            long memoryUsed1 = getMemoryUsed();
            if (memoryUsed != memoryUsed1) {
                memoryUsed = memoryUsed1;
                System.out.println("Memory used :" + memoryUsed + " MB");
            }
            if (runtime != runtime1) {
                runtime = runtime1;
                System.out.println("Runntime :" + runtime + " ms");
            }

        }
    }

    private long getMemoryUsed() {
        return (Runtime.getRuntime()
                .totalMemory() - Runtime.getRuntime()
                .freeMemory()) / 1024 / 1024;
    }

    private Runtime getRuntime() {
        return Runtime.getRuntime();
    }

}
