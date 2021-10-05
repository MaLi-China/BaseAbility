package mchapter01_array;

/**
 * 功能说明：实现两个有序数组合并为一个有序数组
 * 开发人员：@author MaLi
 */
public class Exercise03 {
    public static void main(String[] args) {
        //step1: 初始化两个数组
        int[] arr1 = {1, 3, 5, 7, 9, 100};
        int[] arr2 = {2, 4, 6, 8, 10};
        //step2: 调用合并函数
        int[] result = combineArray(arr1, arr2);
        // 打印结果
        for (int element : result) {
            System.out.println(element);
        }
    }

    private static int[] combineArray(int[] arr1, int[] arr2) {
        int size = arr1.length + arr2.length;
        //创建一个存放结果的数组
        int[] result = new int[size];
        int index1 = 0, index2 = 0; // 创建两个指针, 分别指向arr1,arr2的第一个元素, 在循环中做比较

        for (int i = 0; i < size; i++) {
            if (index1 < arr1.length && index2 < arr2.length) {
                //选择两者最小的放到result中
                result[i] = arr1[index1] <= arr2[index2] ? arr1[index1++] : arr2[index2++];
            } else {
                // 此时有一个数组已经复制完成, 那么开始将另一个数组的剩余元素复制到结果result数组中
                if (index1 >= arr1.length) {
                    //拷贝arr2剩余部分到result
                    System.arraycopy(arr2, index2, result, i, arr2.length - index2);
                } else {
                    //拷贝arr1剩余部分到result
                    System.arraycopy(arr1, index1, result, i, arr1.length - index1);
                }
                // 此时两个数组全部拷贝完成, 要break掉循环
                break;
            }
        }
        return result;
    }
}
