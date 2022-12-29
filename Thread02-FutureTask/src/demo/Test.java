package demo;
import java.time.LocalDate;


public class Test {
    public static void main(String[] args) {
        Coach c = new Coach("阿根廷队", "小明", "男", LocalDate.of(1971, 2, 1),
                "教练", "中国", 13);


        SportMan s = new SportMan("阿根廷队", "梅西","男", LocalDate.of(1985, 10, 24),
                "球员", 188.34, 4);

        System.out.println(c); // 直接输出对象，默认调用toString()
        System.out.println(s);
        c.sing();
        s.slide();
        s.shoot();



    }
}
