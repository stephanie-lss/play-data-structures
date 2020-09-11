package sort;

/**
 * @author LiSheng
 * @date 2020/4/16 23:01
 */
public class Merge {
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void unRecursiveMergeSort(int[] a, int n) {
        int low = 0;
        int high = 0;
        int mid = 0;
        int len = 1;
        while (len <= n) {
            for (int i = 0; i + len <= n; i += 2 * len) {
                low = i;
                mid = i + len - 1;
                high = i + 2 * len - 1;
                if (high > n - 1) {
                    high = n - 1;
                }
                merge(a, low, mid, high);
            }
            len *= 2;
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int n = high - low + 1;
        int[] b = new int[n];
        int bIdx = 0;
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            b[bIdx++] = (a[left] <= a[right]) ? a[left++] : a[right++];
        }
        while (left <= mid) {
            b[bIdx++] = a[left++];
        }
        while (right <= high) {
            b[bIdx++] = a[right++];
        }
        for (int i = 0; i < n; i++) {
            a[low + i] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 3,5};
        mergeSort(a, 0, a.length - 1);
//        unRecursiveMergeSort(a, a.length);
        Print.print(a);
    }
}
