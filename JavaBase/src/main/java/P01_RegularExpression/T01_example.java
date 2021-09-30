package P01_RegularExpression;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能说明：正则表达式示例
 * 开发人员：@author MaLi
 */
public class T01_example {
    private static String sql;

    @Before
    public void init() {
        try {
            InputStream is = T01_example.class.getResourceAsStream("/string.properties");
            Properties properties = new Properties();
            properties.load(is);
            sql = properties.getProperty("sql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void MT01() {
        //Pattern是正则表达式的编译表示
        Pattern pattern = Pattern.compile("\\#\\{[a-z]*\\}");
        Matcher matcher = pattern.matcher(sql);
        boolean b = matcher.find();
        String group = matcher.group();
        boolean b1 = matcher.find();
        System.out.println(b1);
        String s = matcher.replaceAll("?");
        System.out.println(s);
        //TODO 获取组
    }
}
