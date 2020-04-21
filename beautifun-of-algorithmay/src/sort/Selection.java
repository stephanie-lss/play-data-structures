package sort;

/**
 * @author LiSheng
 * @date 2020/4/16 21:24
 */
public class Selection {
    public static void selectionSort(int[] a, int n) {
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int tmp = a[minIndex];
            a[minIndex] = a[idx];
            a[idx++] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        selectionSort(a, a.length);
        Print.print(a);
    }
}
