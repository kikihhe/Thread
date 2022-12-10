package 匿名内部类继承Thread;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-10 11:11
 */
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("一个新的线程");
            }
        };
    }
}
