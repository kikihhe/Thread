package 匿名内部内实现Runnable;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 12:12
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程启动...");
            }
        });
        t.start();
    }
}
