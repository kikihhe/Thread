package lambda表达式;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 12:14
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("线程启动...");
        });
        t.start();
    }
}
