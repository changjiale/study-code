package code.thread;

public class A {

    private volatile int value = 1;

    public static void main(String[] args) {

        A a = new A();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    a.printA();
                }
            }
        }, "线程A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    a.printB();
                }
            }
        }, "线程B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    a.printC();
                }
            }
        }, "线程C").start();

    }
    private void printA() {
        synchronized (this) {
            while (value != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println('A');
            value=2;
            notifyAll();
        }
    }
    private void printB() {
        synchronized (this) {
            while (value != 2) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println('B');
            value =3;
            notifyAll();
        }
    }
    private void printC() {
        synchronized (this) {
            while (value != 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println('C');
            value=1;
            notifyAll();
        }
    }
}

