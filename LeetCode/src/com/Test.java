package com;

/**
 * @author LiSheng
 * @date 2020/3/29 19:02
 */
public class Test {

    //希尔排序
    public static void shellSort(int[] a, int n){
        if (n == 0){
            return;
        }
        int h = 1;
        while (h < n / 3){
            h = 3 * h + 1;
        }

        while (h > 0){
			/*for (int i = h; i < n; i++){
				for (int j = i - h; j >= 0; j -= h){
					if (a[j] > a[j + h]){
						int tmp = a[j];
						a[j] = a[j + h];
						a[j + h] = tmp;
					}
				}
			}*/
            for (int i = h; i < n; i ++){
                int tmp = a[i];
                int j = i - h;
                while (j >= 0 && a[j] > tmp){
                    a[j + h] = a[j];
                    j -= h;
                }
                a[j + h] = tmp;
            }
            h /= 2;
        }
        System.out.println("Shell sort is finished.");
    }

    //计数排序
    public static void countingSort(int[] a, int n){
        if (n == 0){
            return;
        }
        int min = a[0], max = a[0];
        for (int i = 1; i < n; i ++){
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0;i < n; i ++){
            count[a[i] - min] ++;
        }
        int idx = 0;
        for (int i = 0; i < count.length; i ++){
            while (count[i]-- != 0){
                a[idx ++] = i + min;
            }
        }
        System.out.println("Counting sort is finished.");
    }

    //堆排序
    public static void heapSort(int[] a,int n){
        if (n == 0){
            return;
        }
        buildMaxHeap(a, n - 1);

        for (int i = n - 1; i > 0; i --){
            swap(a, 0, i);
            siftDown(a,0, i);
        }
    }

    private static void swap(int[] a, int i, int j){
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    private static void buildMaxHeap(int[] a, int n){
        //获取最后一个父亲节点
        int k = (n - 1) / 2;
        while (k >= 0){
            siftDown(a, k--, n - 1);
        }
    }

    // n闭区间
    private static void siftDown(int[] a, int k, int n){
        while (k * 2 + 1 < n){
            int j = k * 2 + 1;
            if (j + 1 < n && a[j + 1] > a[j]){
                j += 1;
            }
            if (a[k] > a[j]){
                break;
            }else {
                swap(a, k, j);
                k = j;
            }
        }
    }

    public static void main(String[] args){
        int[] a = {4, 2, 34, 345, 34, 0, 1};
        int n = a.length;
        //shellSort(a, n);
        //countingSort(a, n);
        heapSort(a, n);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}