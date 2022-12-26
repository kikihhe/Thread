package futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


public class IsDone轮询 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task1 = new FutureTask<String>(() -> {
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
        Thread t = new Thread(task1, "task1");
        t.start();
        while(true) {
            if (task1.isDone()) {
                break;
            } else {

                System.out.println("还在工作中..");
            }
        }
        System.out.println(task1.get());
        System.out.println("主线程继续工作");
    }
}
