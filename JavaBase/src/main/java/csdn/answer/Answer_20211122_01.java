package csdn.answer;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Answer_20211122_01 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 1, 5, 7, 6, 5, 2};
        System.out.println(process(arr, 0, arr.length - 1));
    }

    public static int process(int[] arr, int L, int r) {
        if (L == r) return 0;
        int M = L + (r - L) / 2;
        return
                process(arr, L, M) +
                        process(arr, M + 1, r) +
                        merge(arr, L, M, r);
    }

    public static int merge(int[] arr, int L, int M, int r) {
        int[] help = new int[r - L + 1];
        int p1 = L, p2 = M + 1, res = 0, i = 0;
        while (p1 <= M && p2 <= r) {
            res += arr[p1] > arr[p2] ? 1 : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[k + L] = help[i];
        }
        return res;
    }
}
