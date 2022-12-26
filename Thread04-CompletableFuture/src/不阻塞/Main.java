package 不阻塞;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-26 11:33
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


    }
    // 继续使用get方法，仍然阻塞
    public static void 阻塞() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始执行任务");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完成");
            return "任务执行完成";
        });
        System.out.println(future.get());
        System.out.println("main执行其他任务");
    }
}
