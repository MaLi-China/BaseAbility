package mchapter01_array;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能说明：数组复制的几种方式
 * 大数据量下, 效率最高的是System.arrayCopy()
 * 开发人员：@author MaLi
 */
//TODO 多线程并发: 线程池运行结束进行统计
public class T01_ArrayCopy {
    private List<String> stringList = Collections.synchronizedList(new ArrayList<String>());

    @Test
    public void method1() throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(8);
        String path = T01_ArrayCopy.class.getResource("").getPath();
        BufferedReader reader = new BufferedReader(new FileReader(path.concat("Strings.txt")));
        String line = null;
        Future<?> future = null;
        while ((line = reader.readLine()) != null) {
            String finalLine = line;
            future = service.submit(() -> {
                String[] split = finalLine.split(" ");
                List<String> strings = Arrays.asList(split);
                stringList.addAll(stringList);
            });

        }
        boolean done = future.isDone();
        while (!done) {
            System.out.println(stringList.size());
        }
    }
}
