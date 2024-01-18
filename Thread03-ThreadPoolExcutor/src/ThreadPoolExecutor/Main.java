package ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-24 19:00
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 20; i++) {
            try {
                executor.execute(new Task(i + ""));
                executor.submit(new Task(i + ""));
            } catch (Throwable e) {
                System.out.println("丢弃任务: " + (i));
            }
        }
        executor.shutdown();
    }
}
