package Chapter12_ClassLoader;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T01_ClassLoader {
    public static void main(String[] args) {
        //查看一个类是被哪个类加载器加载到内存的
        ClassLoader strClassLoader = String.class.getClassLoader();
        System.out.println(strClassLoader);
        System.out.println(T01_ClassLoader.class.getClassLoader());
    }
}
