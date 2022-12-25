package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-25 14:10
 */
public class TestCachedThreadPoole {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        ExecutorService executorService3 = Executors.newScheduledThreadPool(2);
        ExecutorService executorService4 = Executors.newWorkStealingPool();

    }
}
