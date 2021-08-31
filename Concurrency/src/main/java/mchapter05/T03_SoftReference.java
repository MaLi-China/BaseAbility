package mchapter05;

import sun.misc.Unsafe;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：Test the SoftReference
 * 开发人员：@Author MaLi
 */
public class T03_SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> reference = new SoftReference<>(new byte[1024 * 1024 * 1000]);

        System.out.println(reference.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(reference.get());

        byte[] barray = new byte[1024 * 1024 * 1000];

        System.out.println(reference.get());
        Unsafe.getUnsafe().
    }
}
