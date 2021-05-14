package example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 功能说明：发送消息给服务端
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/13
 */
public class EchoClient {

    public static void main(String[] args) {
        Socket client = new Socket();
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            client.connect(new InetSocketAddress("localhost", 8000));
            //1, 发送消息给server端
            writer = new PrintWriter(client.getOutputStream(), true);
            writer.println("abc..");
            writer.flush();
            //2, 接收server端的响应
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line = reader.readLine();
            System.out.println("Server response: " + line);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) writer.close();
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
