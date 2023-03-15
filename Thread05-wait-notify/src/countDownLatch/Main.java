package countDownLatch;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 完成任务: 开启10个线程，每个线程将x自增1000次。在main中查看结果
 *
 */
public class Main {
    private static AtomicInteger x = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    x.incrementAndGet();
                }
                countDownLatch.countDown();
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
//        Thread.sleep(3000);
        countDownLatch.await();
        System.out.println(x.get());

    }
}
