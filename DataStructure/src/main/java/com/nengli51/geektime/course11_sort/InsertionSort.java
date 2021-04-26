package com.nengli51.geektime.course11_sort;

import org.junit.Test;

/**
 * @Author MaLi
 * 插入排序: 小 --> 大
 */
public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        // 边界条件判断
        if (n <= 1) return;
        /*
            外层循环: 遍历未排序区的每一个元素;
               已排序区间: arr[0]
               未排序区间: arr[1]-->arr[n-1]
         */
        int tmp;
        for (int i = 1; i < n; i++) {
            tmp = arr[i];
            int j = i;  // 已排序区间的最后一个元素
            for (; j > 0; j--) {
                // 已排序区间的所有元素与未排序区间的第一个元素
                if (arr[j - 1] > arr[j]) {
                    // 移动元素
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            //插入元素
            arr[j] = tmp;
        }
    }

    @Test
    public void testInsertionSort() {
        int[] arr = {5, 4};
        insertionSort(arr, arr.length);
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
