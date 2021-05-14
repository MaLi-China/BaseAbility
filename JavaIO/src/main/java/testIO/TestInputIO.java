package testIO;

import org.junit.Test;

import java.io.*;

/**
 * 功能说明：文件输入流
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/11
 */
public class TestInputIO {

    @Test
    public void testOther() throws IOException {
        Process exec = Runtime.getRuntime().exec("javac");
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getErrorStream(), "gbk"))
        ) {
            String buff;
            while ((buff = reader.readLine()) != null) {
                System.out.println(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFileOutputStream() {
        File file = new File("tmpdir/tmpfile_to.txt");
        try (
                FileInputStream fis = new FileInputStream("tmpdir/tmpfile.txt");
                FileOutputStream fos = new FileOutputStream(file, true)
        ) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFileReader2() {
        File file = new File("tmpdir/tmpfile.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int len;
            char[] cbuf = new char[1024];
            while ((len = fr.read(cbuf)) != -1) {
                System.out.println(new String(cbuf, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testFileReader1() {
        File file = new File("tmpdir/tmpfile.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int x;
            while ((x = fr.read()) != -1) {
                System.out.println((char) x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileInputStream2() {
        File file = new File("tmpdir/tmpfile.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileInputStream1() throws IOException {
        File file = new File("tmpdir/tmpfile.txt");
        FileInputStream fis = new FileInputStream(file);
        int x;
        try {
            while ((x = fis.read()) != -1) {
                System.out.println((char) x);
            }
        } finally {
            fis.close();
        }
    }
}
