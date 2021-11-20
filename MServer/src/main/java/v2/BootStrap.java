package v2;


import java.io.IOException;
import java.io.InputStream;
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
            //封装数据到Request里面
            InputStream inputStream = socket.getInputStream();
            Request request = new Request(inputStream);

            //通过Response输出数据
            Response response = new Response(socket, request.getUrl());
            response.write();
            socket.close();
        }
    }
}
