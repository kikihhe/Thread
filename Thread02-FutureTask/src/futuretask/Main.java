package futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-26 10:22
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(() -> {
            System.out.println("开始工作");
            try {
                // 工作5s
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("工作完毕");
           return Thread.currentThread().getName() + "->任务执行完毕";
        });
        Thread t = new Thread(task, "task1");
        t.start();
        System.out.println(task.get());
        System.out.println("主线程继续执行其他任务---");
    }
}
