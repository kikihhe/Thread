package 入门;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-26 11:02
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 官方并不推荐使用new获得CompletableFuture
        // 使用静态方法获得 CompletableFuture
        // 1. 任务无返回值 : CompletableFuture.runAsync(Runnable);
        //                 CompletableFuture.runAsync(Runnable, Executor);
        // 由于任务无返回值，该静态方法返回的是 CompletableFuture<Void>
        // 如果非要使用get方法获取返回值，那么获取到的值为null

        // 2. 任务有返回值 : CompletableFuture.supplyAsync(Supplier<T>);
        //                 CompletableFuture.supplyAsync(Supplier<T>, Executor);
        // 任务有返回值，该静态方法返回的是 CompletableFuture<T>, T为任务的返回值.

        // 这些静态方法默认使用 ForkJoinPool.commonPool(), 指定了线程池就使用指定的。
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println("异步任务.该任务无返回值");
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务，该任务有返回值");
            return "hello supplyAsync";
        });

        System.out.println(completableFuture1.get());
        System.out.println(completableFuture2.get());

    }
}
