package sort;

/**
 * @author LiSheng
 * @date 2020/4/16 22:22
 */
public class Shell {
    public static void shellSort(int[] a, int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int tmp = a[i];
                int j = i - h;
                while (j >= 0 && a[j] > tmp) {
                    a[j + h] = a[j];
                    j -= h;
                }
                a[j + h] = tmp;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        shellSort(a, a.length);
        Print.print(a);
    }
}
