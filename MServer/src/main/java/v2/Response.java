package v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Response {
    private String url;
    private Socket socket;

    public Response(Socket socket, String url) {
        this.socket = socket;
        this.url = url;
    }

    public void write() {
        //1, 定位路径, 获取文件
        String path = Response.class.getResource(url).getPath();
        //2, 输出结果
        File file = new File(path);

        try {
            OutputStream outputStream = socket.getOutputStream();

            if (!file.exists() || url.equals("/")) {
                String header = HttpUtils.getHeader(StateCode.ERROR);
                outputStream.write(header.getBytes());
            } else {
                String header = HttpUtils.getHeader(StateCode.SUCCESS);
                //读文件
                FileInputStream fileInputStream = new FileInputStream(file);
                //写文件
                outputStream.write(header.getBytes());
                int len = 0;
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                fileInputStream.close();
            }
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
