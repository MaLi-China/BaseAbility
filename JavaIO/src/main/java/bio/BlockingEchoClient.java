package bio;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 功能说明：使用JavaBIO的Echo服务器-client端
 * 给server端发送消息, 接收server端的返回
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/22
 */
public class BlockingEchoClient {
    private static String DEFAULT_HOSTNAME = "localhost";
    private static int DEFAULT_PORT = 8888;

    public static void main(String[] args) {
        //Logger logger = LoggerFactory.getLogger(BlockingEchoClient.class);
        int port;
        String hostname;
        if (args.length != 2) {
            hostname = DEFAULT_HOSTNAME;
            port = DEFAULT_PORT;
        } else {
            try {
                hostname = args[0];
                port = Integer.parseInt(args[1]);
            } catch (RuntimeException e) {
                hostname = DEFAULT_HOSTNAME;
                port = DEFAULT_PORT;
            }
        }
        try (
                //1, 创建到Server的TCP连接
                Socket socket = new Socket(hostname, port);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                //循环接收来自标准输入
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {

            String line;
            // 接收标准输入
            while ((line = stdIn.readLine()) != null) {
                //2, 将在标准输入获取的数据, 写入到Server端
                writer.println(line);
                System.out.println("写出数据:" + line);
                //3, 接收来自Server端的数据
                System.out.println("来自EchoServer的Msg: " + socketIn.readLine());
            }
        } catch (IOException e) {
            //logger.error("Client启动异常:", e);
        }
    }
}
