package jvmv3.chapter02_04_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 目的:
 * 1, 验证<<Java虚拟机规范>>中描述的运行时数据区中各个区域储存的内容;
 * 2, 遇到内存溢出时, 能够根据异常提示信息迅速得知是哪个区域的内存溢出;
 * 得知什么代码会导致这些区域内存溢出
 * 出现这些异常后, 该如何处理
 * VM args: -Xms:20m -Xmx:20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * 开发人员：@Author MaLi
 */
public class HeapOOM {

    static class OOMObject {
        // 用于创建对象实例, 不断填充堆内存
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
