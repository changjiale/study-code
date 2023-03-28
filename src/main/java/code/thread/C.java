package code.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class C {

    private static Lock lock = new ReentrantLock();
    private static int cnt = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i > 0) {
                try {
                    lock.lock();
                    while (cnt%3 == 0) {
                        System.out.println("A");
                        cnt ++;
                        i--;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i > 0) {
                try {
                    lock.lock();
                    while (cnt%3 == 1) {
                        System.out.println("B");
                        cnt ++;
                        i--;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i > 0) {
                try {
                    lock.lock();
                    while (cnt%3 == 2) {
                        System.out.println("C");
                        cnt ++;
                        i--;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();

    }


}

