package volatile实验;

import java.util.concurrent.CountDownLatch;

public class Main {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; ; i++) {
            x = 0; y = 0; a = 0; b = 0;

            CountDownLatch latch = new CountDownLatch(2);
            Thread one = new Thread(()-> {
                a = 1;
                x = b;
                latch.countDown();
            });
            Thread two = new Thread(() -> {
                b = 1;
                y = a;
                latch.countDown();
            });

            one.start();
            two.start();

            latch.await();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次循环时出现问题: x = " + x + ", y = " + y);
            }
        }
    }
}