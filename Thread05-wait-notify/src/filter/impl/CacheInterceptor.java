package filter.impl;

import filter.Interceptor;
import filter.Request;
import filter.Response;

import java.util.Random;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-11-27 14:57
 */
public class CacheInterceptor extends Interceptor {
    @Override
    public void proceed(Request request) {
        proceed(request);
        // 伪代码
        if (new Random().nextBoolean()) {
            System.out.println("走了缓存，不需要向下执行");
        } else {
            executeNext(request);
        }

    }
}
