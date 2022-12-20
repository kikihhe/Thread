package 多线程打印;

import java.util.concurrent.CountDownLatch;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-20 10:55
 */
public class WorkThread extends Thread{
    private String name;
    private CountDownLatch latch;

    public WorkThread() {
    }

    public WorkThread(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(name);
        latch.countDown();
    }

}
