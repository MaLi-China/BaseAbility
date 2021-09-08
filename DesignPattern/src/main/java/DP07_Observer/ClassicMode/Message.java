package DP07_Observer.ClassicMode;

/**
 * 功能说明：代表消息的抽象类
 * 开发人员：@author MaLi
 */
public class Message {
    private String message = "DefaultMessage...";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
