package jvmv2.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class T03_TestHeap {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> oomObjects = new ArrayList<>();
        while (true) {
            oomObjects.add(new OOMObject());
        }
    }
}
