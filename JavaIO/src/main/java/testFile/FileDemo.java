package testFile;

import java.io.File;
import java.io.IOException;

/**
 * 功能说明：File的API
 * 1, 访问文件和目录
 * 1.1文件名相关
 * 1.2文件检测相关
 * 1.3获取常规文件信息
 * 1.4文件操作相关
 * 1.5目录操作相关
 * 2, 文件过滤器
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/11
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
//        fileMethod3();

        File[] files = File.listRoots();
        for (File f : files) {
            System.out.println(f.getName());
        }
        File file = new File(".");
        File[] fs = file.listFiles();
        for (File f : fs) {
            System.out.println(f.getName());
        }

        //        fileMethod2();
        //        fileMethod1();
    }

    private static void fileMethod3() throws IOException {
        File file = new File("./tmpdir");
        boolean isCreated = file.createNewFile();
        System.out.println(isCreated);
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getParentFile());
        file.deleteOnExit();
    }

    private static void fileMethod2() {
        File file = new File(".");
        boolean exists = file.exists();
        boolean b = file.canRead();
        boolean w = file.canWrite();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        boolean isAbsolute = file.isAbsolute();
        boolean isHidden = file.isHidden();
    }

    private static void fileMethod1() {
        File file = new File(".");
        // 1.1文件名相关
        System.out.println("文件名: " + file.getName());
        System.out.println("文件路径: " + file.getPath());    //File对象对应的路径名
        System.out.println("文件绝对路径: " + file.getAbsoluteFile()); //返回File对象的绝对路径
        System.out.println("文件绝对路径: " + file.getAbsolutePath()); //返回file对象的绝对路径:String
//        file.renameTo(new File("xxx"));
        String parent = file.getParent();
        File parentFile = file.getParentFile();
        System.out.println("文件父路径: " + parentFile.getName());
    }
}
