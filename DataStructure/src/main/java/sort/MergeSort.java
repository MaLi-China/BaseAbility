package sort;

import org.junit.Test;

/**
 * 归并排序
 * 1, merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
 * 2, p>=r
 *
 * @Author MaLi
 */
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        //递归终止条件
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个子序列
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {

        }
        while (i <= mid) {

        }
        while (j <= right) {

        }
        //将tmp数组中的元素全部拷贝到原数组中
        for (int x = 0; x < tmp.length; x++) {
            arr[x + left] = tmp[x];
        }
    }

    /*public int[] mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            return merge(mergeSort(arr, start, mid), mergeSort(arr, mid + 1, end));
        } else {
            return arr;
        }
    }

    */

    /**
     * 合并成为有序数组
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0;
        int index = 0;
        while (i <= arr1.length && j <= arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[index] = arr1[i];
                i++;
            } else {
                result[index] = arr2[j];
                j++;
            }
            index++;
        }
        // 判断剩余数据
        int start = i, end = arr1.length;
        int[] last = arr1;
        if (j < arr2.length) {
            start = j;
            end = arr2.length;
            last = arr2;
        }
        // 剩余数据拷贝到result数组
        while (start <= end) {
            result[index++] = last[start++];
        }
        return result;
    }
    @Test
    public void testMergeSort() {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
//        int[] ints = mergeSort(arr, 0, arr.length);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
    }
}
