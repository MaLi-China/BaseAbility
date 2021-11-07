package path;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Path {
    public static void main(String[] args) {
        //方式1: 获取的根目录
        // /D:/Source/java/BaseAbility/JavaBase/target/classes/
        String path1 = Path.class.getClassLoader().getResource("").getPath();

        // 方式2: 获取的根目录
        // /D:/Source/java/BaseAbility/JavaBase/target/classes/
        String path2 = Path.class.getClassLoader().getResource(".").getPath();

        // 方式3: 当前包下
        // /D:/Source/java/BaseAbility/JavaBase/target/classes/path/
        String path3 = Path.class.getResource(".").getPath();

        // 方式4: 获取根目录
        // /D:/Source/java/BaseAbility/JavaBase/target/classes/
        String path4 = Path.class.getResource("/").getPath();

        // 方式5: 获取web根目录
        //String path = getServletContext().getRealPath("/");
    }
}
