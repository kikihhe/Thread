package volatile实验;

class User {
    int age;
    public int getAge() {
        return age;
    }
}
public class Main1 {


    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            user.age = 100;
            System.out.println("线程将user.age设置为100");
        }).start();


        while (user.getAge() == 0) {

        }
        System.out.println("main结束");
    }
}
