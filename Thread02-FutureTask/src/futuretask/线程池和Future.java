package futuretask;

import java.util.concurrent.*;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-26 10:51
 */
public class 线程池和Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int j = i;
            Future<String> submit = executorService.submit(() -> {
                System.out.println("任务" + j + "开始执行");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务" + j + "执行完毕");
                return "任务" + j + "执行完毕了，这是返回结果";
            });
            System.out.println(submit.get());

        }
    }
}
