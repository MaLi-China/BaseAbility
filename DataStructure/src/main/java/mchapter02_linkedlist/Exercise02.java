package mchapter02_linkedlist;

import org.junit.Test;

/**
 * 功能说明：使用哨兵控制边界, 优化程序性能
 * 解决的问题: 在一个特别长的数据中查找key, 减少判断, 优化程序性能.
 * 开发人员：@author MaLi
 */
public class Exercise02 {
    //常规写法
    public int find(char[] arr, char key) {
        int index = -1;
        //非空判断
        if (arr == null || arr.length == 0) {
            return index;
        }
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    //使用哨兵优化代码: 哨兵用于管理边界(极致要求性能才会这样写, 可读性太差)
    public int find_Plus(char[] arr, char key) {
        int index = -1;
        //非空判断
        if (arr == null || arr.length == 0) {
            return index;
        }
        // 判断最后一个元素是否为key
        if (arr[arr.length - 1] == key) {
            return arr.length - 1;
        }

        char tmp = arr[arr.length - 1]; //恢复数组用
        arr[arr.length - 1] = key;
        for (int i = 0; ; i++) { //省略判断条件的性能
            if (key == arr[i]) { //在这里控制边界
                index = i;  //说明数组中有key
                break;
            }
        }
        if (index == arr.length - 1) { //说明数组中没有key
            index = -1;
        }
        arr[arr.length - 1] = tmp; //恢复数组
        return index;
    }


    @Test
    //在数组a中，查找key，返回key所在的位置
    public void test_M1_find() {
        String message = "hello java";
        char[] arr = message.toCharArray();
        int i = find(arr, 'o');
        System.out.println(i);
    }
}
