package filter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-11-27 13:02
 */

public class Request {
    private String url;

    private Map<String, Object> header;

    private String body;

    public Request() {
        header = new HashMap<>();
    }
    public void addHeader(String name, Object value) {
        header.put(name, value);
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
