package guard;

import java.util.Objects;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-01-30 18:59
 */
public class GuardObject {
    // 结果
    private Object response;

    // 获取结果
    public Object getResponse() {
        // 如果获取不到结果(response为空)，一直阻塞
        synchronized(this) {
            while(Objects.isNull(response)) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }

    public void setResponse(Object response) {
        // 有结果了，唤醒GuardObject中的get
        synchronized(this) {
            this.response = response;
            this.notifyAll();
        }

    }
}
