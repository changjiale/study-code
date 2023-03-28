package code.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class D{





    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i=0; i<5; i++) {
            Thread thread = new Thread(new DownLoadWorker(countDownLatch));
            thread.start();
        }

        countDownLatch.await();
        System.out.println("图片已下载完~~~");

    }


}

class DownLoadWorker implements Runnable {

    private CountDownLatch countDownLatch;

    public DownLoadWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {

        System.out.println("线程" + Thread.currentThread().getName() + "开始下载完成");
        countDownLatch.countDown();

    }
}

