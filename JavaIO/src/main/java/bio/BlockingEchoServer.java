package bio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能说明：Java原生BIO网络编程-服务器端
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/22
 */
public class BlockingEchoServer {

    private static int DEFAULT_PORT = 8888;

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(BlockingEchoServer.class);
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (RuntimeException e) {
            port = DEFAULT_PORT;
            System.out.println("端口参数输入存在问题, 以默认端口号: 8888启动服务器.");
        }
        ServerSocket serverSocket = null;
        try {
            //1, 创建ServerSocket
            serverSocket = new ServerSocket(port);
            System.out.println("启动成功...");
        } catch (IOException e) {
            System.out.println("启动异常...");
            e.printStackTrace();
        }
        try (
                //2, 阻塞接收来自客户端连接
                Socket socket = serverSocket.accept();
                //3, 通过IO流, 进行数据传输
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)
        ) {
            String line;
            // 读来自客户端的数据
            while ((line = reader.readLine()) != null) {
                System.out.println("收到客户端消息: " + line);
                // 写数据到客户端
                writer.println(line);
            }
        } catch (IOException e) {
            logger.error("Server启动异常:", e);
        }
    }
}
