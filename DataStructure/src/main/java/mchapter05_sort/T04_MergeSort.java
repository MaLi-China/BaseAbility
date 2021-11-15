package mchapter05_sort;

import org.junit.Test;

/**
 * 功能说明：归并排序
 * 开发人员：@author MaLi
 */
public class T04_MergeSort {
    //排序功能入口
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归方法
     * 功能: 对arr数组的子区间进行迭代排序
     * 解释: 采用分治思想, 使用递归方式实现, 递归公式如下
     * sort(arr,start,end) = sort(arr,start,mid)+sort(arr,mid+1,end)
     * 递归终止条件: arr子区间的长度==1, 也就是start=end的时候
     *
     * @param arr   待排序数组
     * @param start 区间左边界
     * @param end   区间右边界
     */
    public void sort(int[] arr, int start, int end) {
        //此处为数组合法性检验
        //1, arr为null, 无法排序
        //2, arr的元素为1, 只有一个元素, 无需排序
        if (arr == null || arr.length <= 1) {
            return;
        }
        //递归代码块
        if (start == end) {
            //此处是递归终止条件: 即arr子区间的长度==1, 也就是start=end的时候, 递归终止, 动作是: 返回
            return;
        } else {

            int mid = (start + end) / 2;
            int[] tmp = new int[end - start + 1]; //使用tmp临时数组的目的: 传递给merge函数, 保存排序子区间, 然后拷贝到arr的指定位置
            //此处是递归递推公式的翻译:总体数据在mid出拆分为两个子规模的数据, 分别进行sort排序
            // 注意: 理解递归的关键 --- 只要设定好了终止条件写好了递推公式, 人脑不要推断递归过程, 非要理解的话, 记住jvm虚拟机栈中栈帧的工作原理就可以了
            sort(arr, start, mid); //leftArr
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end, tmp);
        }
    }

    /**
     * 分治思想的: 治(合)阶段, 在该逻辑实现中目的: 合并排序后的数组
     * 具体逻辑: 两个数组合并为有序的一个数组
     * 两个数组分别是: leftArr[start,mid] 与rightArr[mid+1,end]
     *
     * @param arr   待排序数组
     * @param start 区间左边界: leftArr[start,mid]
     * @param mid   中间位置 : leftArr[start,mid] 与rightArr[mid+1,end]
     * @param end   区间右边界: rightArr[mid+1,end]
     * @param tmp   临时数组
     */
    public void merge(int[] arr, int start, int mid, int end, int[] tmp) {
        int leftIndex = start;      // 左数组leftArr[start,mid]的元素指针初始化
        int rightIndex = mid + 1;   //右数组rightArr[mid+1,end]的元素指针初始化
        int index = 0;              //tmp数组存储指针初始化
        // 下面的逻辑是, 将leftArr,rightArr的每一个元素, 排序合并到tmp中(归并算法名字的由来)
        // 循环1, 分别拿leftArr的当前指针指向元素与rightArr的当前指针指向元素比较大小, 取小的放入tmp的index指针位置
        while (leftIndex <= mid && rightIndex <= end) {
            if (arr[leftIndex] < arr[rightIndex]) {
                tmp[index++] = arr[leftIndex++];    //取的谁, 就移动一下谁的指针(取的leftArr)  同时index也++移动了一次指针
            } else {
                tmp[index++] = arr[rightIndex++];    //取的谁, 就移动一下谁的指针(取的rightArr)
            }
        }
        //循环2,目的: leftArr的剩余元素拷贝到tmp  (对应的情况, leftArr的值比rightArr中元素大, 有剩余, 就将剩余元素整体拷贝到tmp)
        //有可能不执行此循环
        while (leftIndex <= mid) {
            tmp[index++] = arr[leftIndex++];
        }
        //循环3, 目的: rightArr的剩余元素拷贝到tmp (对应的情况, righttArr的值比leftArr中元素大, 有剩余, 就将剩余元素整体拷贝到tmp)
        //有可能不执行此循环,循环3与循环2只有一个会执行
        while (rightIndex <= end) {
            tmp[index++] = arr[rightIndex++];
        }
        //最终关键一步: 拷贝tmp数组元素到arr数组中, arr即为结果
        System.arraycopy(tmp, 0, arr, start, tmp.length);
    }

    /**
     * 该处为测试代码
     */
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
