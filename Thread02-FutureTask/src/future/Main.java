package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : 小何
 * @Description : FutureTask异步线程任务可以显著提高效率
 * @date : 2022-12-24 16:14
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new CallableImpl());
        Thread t1 = new Thread(task);

        t1.start();
        String result = task.get();
        System.out.println(result);
    }
}
