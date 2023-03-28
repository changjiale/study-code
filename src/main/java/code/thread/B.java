package code.thread;

public class B {


    public static void main(String[] args) throws InterruptedException {
        Object A = new Object();
        Object B = new Object();
        Object C = new Object();
        PrintThread a = new PrintThread("A", C, A);
        PrintThread b = new PrintThread("B", A, B);
        PrintThread c = new PrintThread("C", B, C);
        new Thread(a).start();
        Thread.sleep(10);
        new Thread(b).start();
        Thread.sleep(10);
        new Thread(c).start();
        Thread.sleep(10);

    }


}

class PrintThread implements Runnable {

    private String name;
    private Object pre;
    private Object self;

    PrintThread(String name, Object pre, Object self) {
        this.name = name;
        this.pre = pre;
        this.self = self;
    }


    @Override
    public void run() {
        int i = 10;
        while (i-- > 0) {
            synchronized (pre) {
                synchronized(self) {
                    System.out.println(name);
                    self.notifyAll();
                }
                try {
                    pre.wait(); // 立即释放 prev锁，当前线程休眠，等待唤醒
                    /**
                     * JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行。
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
