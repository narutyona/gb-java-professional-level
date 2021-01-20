package com.geekbrains.server;

public class WaitNotifyClass {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public static void PrintABC() {
        WaitNotifyClass w = new WaitNotifyClass();
        Thread aThread = new Thread(() -> {
            w.printA();
        });
        Thread bThread = new Thread(() -> {
            w.printB();
        });
        Thread cThread = new Thread(() -> {
            w.printC();
        });

        aThread.start();
        bThread.start();
        cThread.start();

        try {
            cThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'C';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
