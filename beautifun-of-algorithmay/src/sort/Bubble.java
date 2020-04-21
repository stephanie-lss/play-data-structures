package sort;

/**
 * @author LiSheng
 * @date 2020/4/16 21:12
 */
public class Bubble {
    public static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        bubbleSort(a, a.length);
        Print.print(a);
    }

}
