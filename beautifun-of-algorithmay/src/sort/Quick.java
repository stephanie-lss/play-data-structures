package sort;

/**
 * @author LiSheng
 * @date 2020/4/17 11:25
 */
public class Quick {

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int m = partition(a, low, high);
            quickSort(a, low, m - 1);
            quickSort(a, m + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int p = a[low];
        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (a[j] < p && i++ != j) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }

        int tmp = a[low];
        a[low] = a[i];
        a[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        quickSort(a, 0, a.length - 1);
        Print.print(a);
    }
}
