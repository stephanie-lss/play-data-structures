package sort;

/**
 * @author LiSheng
 * @date 2020/6/21 16:49
 */
public class HeapSort {
    public static void heapSort(int[] a,int n){
        if (n == 0){
            return;
        }
        buildMaxHeap(a, n - 1);
        for (int i = n - 1; i >= 0; i--){
            swap(a, 0, i);
            siftDown(a, 0, i);
        }
    }

    private static void buildMaxHeap(int[] a, int n){
        int k = (n - 1) / 2;
        while (k >= 0){
            siftDown(a, k--, n + 1);
        }
    }

    private static void siftDown(int[] a, int k, int n){
        while (2 * k + 1 < n){
            int j = 2 * k + 1;
            if (j + 1 < n && a[j + 1] > a[j]){
                j += 1;
            }
            if (a[k] > a[j]){
                break;
            }else{
                swap(a, j, k);
                k = j;
            }
        }
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args){
        int[] a = {312, 4, 3, 34, 5, 34, 1, 3};
        //bubbleSort(a, a.length);
        //selectSort(a, a.length);
        //insertSort(a, a.length);
        //shellSort(a, a.length);
        //mergeSort(a, 0, a.length - 1);
        //mergeSortNR(a, a.length);
        //quickSort(a, 0, a.length - 1);
        heapSort(a, a.length);
        for (int n : a){
            System.out.print(n + " ");
        }
    }
}
