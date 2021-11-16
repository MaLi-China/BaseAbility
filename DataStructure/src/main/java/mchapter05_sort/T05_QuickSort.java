package mchapter05_sort;

import org.junit.Test;

/**
 * 功能说明：快速排序
 * 开发人员：@author MaLi
 */
public class T05_QuickSort {
    /**
     * 排序入口
     *
     * @param arr 待排序数组
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 排序逻辑: 一句话概括, 找一个基准点(该程序选end位置的元素作为基准点), 基准点左边的比都是小的, 右边都是比基准点大的
     * 然后分治, 基准点两边各自执行相同的逻辑: 再各自找基准点, 各自的基准点的两边一边小, 一边大, 然后继续分治...
     * 直到基准点的两边只有一个元素
     * 思想是分治, 逻辑如上, 编程实现如下:
     * 1, 使用递归
     * 2, 选end, 也就是数组的最后一个元素作为基准点
     * 3, 选i作为 "已排序区间" 与"未排序区间"的分界
     * 4, 遍历未排序区间(使用j作为指针的循环), 如果比基准点小, 就放到已排序区间, 编程代码就是: 与i所在位置交换, i挪动到下一个位置(这是第一步)
     * 5, 关于j指针的循环遍历完成后, 交换基准点和i --> 目的: 为下面分治做准备, 这样基准点的两边有各自的特点: 左边都比基准点小, 右边反之;
     * 6, 基准点的两边递归上面的逻辑, 直到基准点的两边剩余一个元素, 递归结束, 数组已经有序了.
     * 总结: 每一遍循环, 实现的结果有两个: 1,小的和大的分界;2, 基准点放到分界位置 --> 开启新的分治阶段
     *
     * @param arr   待排序数组
     * @param start 首元素位置
     * @param end   尾元素位置
     */
    public void sort(int[] arr, int start, int end) {
        // 递归结束条件: 只有一个元素
        if (start >= end) {
            return;
        }
        // 设定i为已排序与未排序的分界, 首先i指向未排序区间的第一个位置(这里刚开始, 初始化指向start)
        int i = start;
        // 关键逻辑1: 将数组中除去基准点外, 所有的元素以比基准点为标准分大小, 小的放左边, 大的放右边
        // 放左与放右, 体现在代码上就是是否交换i与j位置的元素, 如果小于基准点, 那么就将这个元素放到边界内
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[end]) {
                // 交换一下就放到边界内了
                swap(arr, i, j);
                // 还要把i边界往后挪动以为
                i++;
            }
        }
        // 把基准点放到边界位置上, 这样才做到左边的比基准点小, 右边的比基准点大
        swap(arr, i, end);
        //递归: 分治即把左右两边按照相同逻辑处理
        sort(arr, start, i - 1);
        sort(arr, i + 1, end);
    }

    /**
     * 交换数组中两个位置上的元素
     *
     * @param arr    待排序数组
     * @param index1 交换位置的角标1
     * @param index2 交换位置的角标2
     */
    public void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    // 以下为测试代码
    @Test
    public void testSort() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("-------------------");
        arr = new int[]{1};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("-------------------");
        arr = new int[]{};
        sort(arr);
        System.out.println(arr);
    }
}
