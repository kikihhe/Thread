package filter;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-11-27 15:09
 */
public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.setUrl("www.baidu.com");

        InterceptorChain chain = InterceptorChain.Builder.build(null);
        chain.doFilter(request);

    }
}
