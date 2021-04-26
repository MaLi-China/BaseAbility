package com.nengli51.geektime.course11_sort;


import org.junit.Test;

/**
 * @Author MaLi
 * @Date 2021/4/26
 * 冒泡排序
 */
public class BubbleSort {
    /**
     * @param arr 待排序数组
     * @param n   数组长度
     */
    public void bubbleSort(int[] arr, int n) {
        // 边界判断: 数组长度
        if (n <= 1) return;
        // 数据交换标志
        boolean isExchanged;
        int tmp;
        for (int i = 0; i < n - 1; i++) {
            isExchanged = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isExchanged = true;
                }
            }
            // 如果没有数据交换, 提前退出循环
            if (!isExchanged) {
                return;
            }
        }
    }

    @Test
    public void testBubbleSort() {
        int[] arr = {9};
        bubbleSort(arr, 1);
        for (int e : arr) {
            System.out.println(e);
        }
    }
}
