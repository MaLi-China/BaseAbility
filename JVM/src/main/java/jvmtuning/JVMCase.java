package jvmtuning;

import java.io.IOException;

/**
 * 功能说明：ReservedCodeCacheSize
 * 开发人员：@author MaLi
 */
public class JVMCase {
    public static void main(String[] args) {
        System.out.println("JVMCase is waiting...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
