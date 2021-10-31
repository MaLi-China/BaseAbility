package Chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：使用Serial与SerialOld垃圾回收器
 * -XX:+PrintCommandLineFlags
 * -XX:+UseSerialGC
 * 开发人员：@author MaLi
 */
public class T01_SerialGC {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        //砖, 用来挤占空间
        byte[] barr = new byte[1024 * 1024 * 1024];
        while (true) {
            //给GCRoots不断增加 1M 堆空间占用
            list.add(barr);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
Default GC
-XX:G1ConcRefinementThreads=8
-XX:GCDrainStackTargetSize=64
-XX:InitialHeapSize=668687360
-XX:MaxHeapSize=10698997760
-XX:+PrintCommandLineFlags
-XX:ReservedCodeCacheSize=251658240
-XX:+SegmentedCodeCache
-XX:+UseCompressedClassPointers
-XX:+UseCompressedOops
-XX:+UseG1GC
-XX:-UseLargePagesIndividualAllocation

Test GC
-XX:InitialHeapSize=668687360
-XX:MaxHeapSize=10698997760
-XX:+PrintCommandLineFlags
-XX:ReservedCodeCacheSize=251658240
-XX:+SegmentedCodeCache
-XX:+UseCompressedClassPointers
-XX:+UseCompressedOops
-XX:-UseLargePagesIndividualAllocation
-XX:+UseSerialGC

 **/
