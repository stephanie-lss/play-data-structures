package sort;

/**
 * @author LiSheng
 * @date 2020/4/16 21:53
 */
public class Insert {
    public static void insertSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j + 1] < a[j]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void insertSortPlus(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < a[j]) {
                    a[j + 1] = a[j];
                    if (j == 0) {
                        a[j] = tmp;
                    }
                } else {
                    a[j + 1] = tmp;
                }
            }

        }
    }

    public static void insertSortPlus2(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int tmp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > tmp) {
                a[j + 1] = a[j--];
            }
            a[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        insertSortPlus2(a, a.length);
        Print.print(a);
    }
}