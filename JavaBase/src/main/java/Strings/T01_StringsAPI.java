package Strings;

import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T01_StringsAPI {
    @Test
    public void MT01() {
        String filename = "0123456.txt";
        String substring = filename.substring(filename.lastIndexOf("."));
        System.out.println(substring);
    }
}
