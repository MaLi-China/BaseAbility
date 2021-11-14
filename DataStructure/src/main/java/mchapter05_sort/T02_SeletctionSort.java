package mchapter05_sort;

import org.junit.Test;

/**
 * 功能说明: 选择排序
 * 1, 找未排序区间里面找最小的
 * 2, 替换  已排序区的最后位置 <--交换--> 未排序区的最小值
 * 开发人员：@author MaLi
 */
public class T02_SeletctionSort {
    public int[] sort(int[] arr) {
        // 检测参数
        if (arr == null || arr.length <= 1)
            return arr;
        //外层逻辑: 变量0到倒数第2位区间, 即[0,length-2], 找最小 (不遍历到length-1这个位置的原因: 只剩一位, 没有大小可比)
        for (int i = 0; i < arr.length - 1; i++) {
            //记录下最小值的索引, 用于结果赋值
            int minIndex = i;
            //内层逻辑:  找未排序区间中最小的元素索引, 即区间[i+1,length-1], (之所以左边界为i+1, 如果起始设定在第i个位置, 那浪费一次比较--和自己比没有意义)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 在外层遍历中, 把未排序区中最小的放到指定位置
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    @Test
    public void testSort() {
        int[] arr = {3, 2, 1};
        arr = sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        arr = new int[]{1};
        arr = sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        arr = new int[]{};
        arr = sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        arr = null;
        arr = sort(arr); //此处返回null
        System.out.println(arr);
    }
}
