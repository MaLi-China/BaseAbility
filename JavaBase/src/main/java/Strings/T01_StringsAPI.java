package Strings;

import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T01_StringsAPI {

    @Test
    public void testIntern() {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = s1.intern();
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s1.equals(s3));
    }


    @Test
    public void MT01() {
        String filename = "0123456.txt";
        String substring = filename.substring(filename.lastIndexOf("."));
        System.out.println(substring);
    }
}
