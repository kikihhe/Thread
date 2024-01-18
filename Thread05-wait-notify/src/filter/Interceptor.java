package filter;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-11-27 13:04
 */
public abstract class Interceptor {
    public Interceptor next;

    public void setNext(Interceptor interceptor) {
        this.next = next;
    }
    public abstract void proceed(Request request) ;

    /**
     * 执行下一个interceptor
     * @param request
     */
    public void executeNext(Request request) {
        if (next != null) {
            next.proceed(request);
        }
    }

    public Interceptor getNext() {
        return next;
    }
}
