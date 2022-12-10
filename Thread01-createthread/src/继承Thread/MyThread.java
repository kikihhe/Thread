package 继承Thread;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 11:08
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("新线程运行...");
    }
}
