package 多线程求和;

import java.util.Random;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 12:16
 */
public class Main {
    private static int[] arr = null;
    // 第一个线程求和后的值
    private static long sum1 = 0;
    // 第二个线程求和后的值
    private static long sum2 = 0;

    public static void main(String[] args) {
        arr = new int[10];
        createArray();
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < arr.length/2; i+=2) {
                sum1 += arr[i];
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i < arr.length; i+=2) {
                sum2 += arr[i];
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("结果为:" + (sum1 + sum2));
        System.out.println("共运行了:" + (end - start) + "ms");
    }
    private static void createArray() {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(101);
        }
    }
}
