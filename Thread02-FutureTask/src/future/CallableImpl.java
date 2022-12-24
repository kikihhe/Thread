package future;

import java.util.concurrent.Callable;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-24 16:17
 */
public class CallableImpl implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("---- 开始打印日志 ----");

        return "日志打印完成";
    }
}
