package 帮右友;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-29 13:59
 */
public class Test7 {
    public static void main(String[] args) {
        Switch s1 = new LightSwitch();
        Switch s2 = new FanSwitch();
        s1.on();
        s1.off();
        s2.on();
        s2.off();
    }
}
