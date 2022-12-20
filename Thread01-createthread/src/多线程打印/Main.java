package 多线程打印;

import java.util.concurrent.CountDownLatch;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-20 10:40
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            Thread thread = new WorkThread(i + "", latch);
            thread.start();
        }
        latch.await();
        System.out.println("ok");
    }
}
