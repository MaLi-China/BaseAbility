package Chapter12_ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T07_ClassLoader {

    public static void main(String[] args) {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        try {
            Object p = loader.loadClass("Chapter12_ClassLoader.Person").newInstance();
            System.out.println(p.getClass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
