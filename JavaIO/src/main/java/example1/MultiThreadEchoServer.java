package example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能说明：多线程的Socket服务器
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/13
 */
public class MultiThreadEchoServer {
    //1,创建线程池
    private static ExecutorService theadPool = Executors.newCachedThreadPool();

    //2, main方法中处理消息接收和写出
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                SocketAddress remoteSocketAddress = clientSocket.getRemoteSocketAddress();
                System.out.println("Connected by" + remoteSocketAddress);
                theadPool.execute(new HandleMsg(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 静态内部类功能: EchoServer的处理消息功能
    static class HandleMsg implements Runnable {
        private Socket clientSocket;

        public HandleMsg(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            BufferedReader reader = null;
            PrintWriter writer = null;
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream());
                String line;
                long start = System.currentTimeMillis();
                while ((line = reader.readLine()) != null) {
                    writer.println(line);
                    System.out.println("line: " + line);
                    writer.flush();
                }
                long end = System.currentTimeMillis();
                System.out.println("Time Spend: " + (end - start) + "ms.");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) reader.close();
                    if (writer != null) writer.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
