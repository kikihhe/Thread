package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author : 小何
 * @Description : FutureTask异步线程任务可以显著提高效率

 1. 实现Callable接口，在其中完成任务以及返回值
 2. 创建FutureTask对象，构造方法需要一个Callable，使用FutureTask.get()可以获得Callable的返回值
 3. 创建Thread对象，以FutureTask作为构造方法的参数
    Thread t = new Thread(futureTask);
    启动县城后，开始执行Callable的call()方法。
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
