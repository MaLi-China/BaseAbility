package Base_06;

import java.io.*;

/**
 * 功能说明： 读取文件内容, 输出指定的格式数据
 * 开发人员：@Author MaLi
 */
public class Demo_01_POP {
    public void testMethod() {
        // 1, 读取文件users.txt的每一行
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            new BufferedReader(new InputStreamReader(new FileInputStream("users.txt")));
            new BufferedWriter(new OutputStreamWriter(new FileOutputStream("formatted_users.txt")));

            String line = "";
            while ((line = reader.readLine()) != null) {
                // 2, 替换为指定字符串
                line = line.replace("&", "\")");
                // 3, 写入formatted_users.txt
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
