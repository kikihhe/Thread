package 实现Runnable;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 11:10
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
