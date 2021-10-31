package Chapter04;

import java.io.IOException;

/**
 * 功能说明：使用jstack
 * 开发人员：@author MaLi
 */
public class T01_Command_jstack {
    public static void main(String[] args) {
        System.out.println("jstack...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
