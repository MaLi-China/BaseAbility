package v1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class BootStrap {
    public static void main(String[] args) {
        try {
            new BootStrap().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int port = 8080;

    //接收客户端请求
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            String header = HttpUtils.getHeader(StateCode.SUCCESS);
            outputStream.write((header + "connnection success").getBytes());
            socket.close();
        }
    }
}
