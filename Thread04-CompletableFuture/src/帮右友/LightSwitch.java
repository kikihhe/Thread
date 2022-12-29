package 帮右友;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-29 13:57
 */
public class LightSwitch implements Switch{
    @Override
    public void on() {
        System.out.println("电灯开关开启");
    }

    @Override
    public void off() {
        System.out.println("电灯开关关闭");
    }
}
