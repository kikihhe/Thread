package 实现Runnable;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 11:10
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("新线程启动...");
    }
}
