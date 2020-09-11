package com.solution275;

/**
 * @author LiSheng
 * @date 2020/6/1 9:51
 */
public class Solution3 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) {
            return 0;
        }
        int left = 0, right = n - 1;
        int hIndex = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                hIndex = Math.max(hIndex, n - mid);
                right = mid - 1;
            } else if (citations[mid] < n - mid) {
                left = mid + 1;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        int[] cit = {0, 1, 3, 5, 6};
        System.out.println(new Solution3().hIndex(cit));
    }
}
