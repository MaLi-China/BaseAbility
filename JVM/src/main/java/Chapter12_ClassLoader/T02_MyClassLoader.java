package Chapter12_ClassLoader;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T02_MyClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = null;
        try {
            //1, 将文件加载到内存, 转换为字节数组
            InputStream is = T02_MyClassLoader.class.getResourceAsStream("/Chapter12_ClassLoader/Person.class");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int x = 0;
            while ((x = is.read()) != -1) {
                baos.write(x);
            }

            is.close();
            bytes = baos.toByteArray();
            baos.close();

            //2, 将字节数组转换为class对象
            return defineClass("Chapter12_ClassLoader.Person", bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass("Chapter12_ClassLoader.Person");
    }

    @Test
    public void testMyClassLoader() {
        try {
            Class<?> aClass = findClass("Person.class");
            try {
                Object o = aClass.newInstance();
                System.out.println(o.getClass().getClassLoader());
                System.out.println(T02_MyClassLoader.class.getClassLoader());
//                ((Person)o).doAction();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testByteArray() throws IOException {


        //System.out.println(bytes.length);


    }


    @Test
    public void testClassFile() {
        String path = T02_MyClassLoader.class.getClassLoader().getResource("Person.class").getPath();
        File file = new File(path);
        System.out.println(file.exists());

        InputStream inputStream = T02_MyClassLoader.class.getClassLoader().getResourceAsStream("Person.class");
        try {
            int available = inputStream.available();
            System.out.println(available);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPath() {
        //获取路径1
        // /D:/Source/java/BaseAbility/JVM/target/classes/
        String path = T02_MyClassLoader.class.getClassLoader().getResource("").getPath();
        // /D:/Source/java/BaseAbility/JVM/target/classes/
        path = T02_MyClassLoader.class.getClassLoader().getResource(".").getPath();
        // path = T02_MyClassLoader.class.getClassLoader().getResource("/").getPath();

        //获取路径2
        // /D:/Source/java/BaseAbility/JVM/target/classes/Chapter12_ClassLoader/
        String path1 = T02_MyClassLoader.class.getResource("").getPath();
        // /D:/Source/java/BaseAbility/JVM/target/classes/Chapter12_ClassLoader/
        path1 = T02_MyClassLoader.class.getResource(".").getPath();
        // /D:/Source/java/BaseAbility/JVM/target/classes/
        path1 = T02_MyClassLoader.class.getResource("/").getPath();

        // 获取字节流1
        InputStream inputStream = T02_MyClassLoader.class.getClassLoader().getResourceAsStream("");
        inputStream = T02_MyClassLoader.class.getClassLoader().getResourceAsStream(".");
        //inputStream = T02_MyClassLoader.class.getClassLoader().getResourceAsStream("/");

        // 获取字节流2
        InputStream stream = T02_MyClassLoader.class.getResourceAsStream("");
        stream = T02_MyClassLoader.class.getResourceAsStream(".");
        stream = T02_MyClassLoader.class.getResourceAsStream("/");
    }
}
