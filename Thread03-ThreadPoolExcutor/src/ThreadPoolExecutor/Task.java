package ThreadPoolExecutor;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-24 19:02
 */
public class Task implements Runnable{
    public String id;

    public Task(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("线程: " +Thread.currentThread().getName() +  " 执行任务: " + id);
    }
}
