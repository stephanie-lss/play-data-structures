package com.array.easy.solution1385;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/4/1 11:52
 */
public class Solution2 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        Arrays.sort(arr2);
        for (int i : arr1) {
            boolean flag = true;
            int left = 0;
            int right = arr2.length - 1;
            while (left <= right) {
                int mid = right - (right - left) / 2;
                if (Math.abs(i - arr2[mid]) <= d) {
                    flag = false;
                    break;
                }
                if (i - arr2[mid] > d) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            count += flag ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {-4, -3, 6, 10, 20, 30};
        int d = 3;
        System.out.println(new Solution2().findTheDistanceValue(arr1, arr2, d));
    }
}
