package filter;

import filter.impl.CacheInterceptor;
import filter.impl.TokenInterceptor;

import java.util.List;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-11-27 15:31
 */
public class InterceptorChain {
    // 第一个拦截器
    private Interceptor firstInterceptor = new Interceptor() {
        @Override
        public void proceed(Request request) {
            System.out.println("虚拟头节点");
        }
    };
    // 最后一个拦截器
    private Interceptor lastInterceptor = firstInterceptor;


    // 执行过滤器链
    public void doFilter(Request request) {
        // 第一个执行完后会执行第二个，循环往复直到执行完。
        firstInterceptor.next.proceed(request);
    }

    public void addFirst(Interceptor interceptor) {
        interceptor.next = firstInterceptor.next;
        firstInterceptor.next = interceptor;

        if (firstInterceptor == lastInterceptor) {
            lastInterceptor = interceptor;
        }
    }

    public void addLast(Interceptor interceptor) {
        lastInterceptor.next = interceptor;
        lastInterceptor = interceptor;
    }
    public static class Builder {
        public static InterceptorChain build(List<Interceptor> interceptors) {
            InterceptorChain interceptorChain = new InterceptorChain();
            // 添加用户自定义的拦截器
            if (interceptors != null && !interceptors.isEmpty()) {
                interceptors.forEach(interceptorChain::addLast);
            }
            TokenInterceptor tokenInterceptor = new TokenInterceptor();
            CacheInterceptor cacheInterceptor = new CacheInterceptor();

            interceptorChain.addLast(tokenInterceptor);
            interceptorChain.addLast(cacheInterceptor);
            return interceptorChain;
        }
    }

}
