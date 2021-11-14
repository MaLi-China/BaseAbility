package mchapter05_sort;

import org.junit.Test;

/**
 * 功能说明：插入排序
 * 已排序 | 未排序
 * 开发人员：@author MaLi
 */
public class T01_InsertionSort {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        //第一层循环, 区间: [1,length-1] , 逻辑:该区间设为未排序区间, 遍历未排序区间的每一个元素, 依次将每一个元素与排序区间的元素比较
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];     // 把要插入的值保存下来
            int j = i;              // 角标后面赋值用
            //第二层循环 [i-1,0]: 目的: 查找要插入的位置
            for (; j > 0; j--) {
                //移动元素: 当前元素的前一位, 如果比value大, 那么就把该元素移动到下一位
                if (arr[j - 1] > value) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = value;
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
