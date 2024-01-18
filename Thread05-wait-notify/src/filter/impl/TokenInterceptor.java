package filter.impl;

import filter.Interceptor;
import filter.Request;

public class TokenInterceptor extends Interceptor {
    @Override
    public void proceed(Request request) {
        String token = "123";
        request.addHeader("token", token);
        System.out.println("添加了token, 继续向下执行");
        executeNext(request);
    }
}