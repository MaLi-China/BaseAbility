package v2;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class HttpUtils {

    public static String getHeader(StateCode stateCode) {
        StringBuilder httpHeader = new StringBuilder();
        switch (stateCode) {
            case SUCCESS:
                httpHeader.append("HTTP/1.1 200 OK\n");
                httpHeader.append("Content-Type: text/html;charset=utf-8\n");
                httpHeader.append("\r\n");
                break;
            case ERROR:
                httpHeader.append("HTTP/1.1 404 Not Found\n");
                httpHeader.append("Content-Type: text/html;charset=utf-8\n");
                httpHeader.append("\r\n");
                break;
            default:
                break;
        }
        return httpHeader.toString();
    }
}
