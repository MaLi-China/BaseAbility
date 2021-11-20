package v2;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Request {
    private InputStream inputStream;
    private String requestMethod;
    private String url;

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
        int size = 0;
        try {
            while (size == 0) {
                size = inputStream.available();
            }
            String requestContent = new String(inputStream.readAllBytes());
            String requestHeader = requestContent.split("\r")[0];
            String[] requestHeaders = requestHeader.split(" ");
            this.requestMethod = requestHeaders[0];
            this.url = requestHeaders[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestMethod='" + requestMethod + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
