package com.solution88;

/**
 * @author LiSheng
 * @date 2020/2/23 14:54
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = 0;
        int r = 0;
        int[] tmp = new int[n + m];
        int count = 0;
        while (l < m && r < n) {
            if (nums1[l] < nums2[r]) {
                tmp[count++] = nums1[l++];
            } else if (nums1[l] > nums2[r]) {
                tmp[count++] = nums2[r++];
            } else {
                tmp[count++] = nums1[l++];
                tmp[count++] = nums2[r++];
            }
        }
        if (l == m) {
            for (int i = r; i < nums2.length; i++) {
                tmp[count++] = nums2[i];
            }
        } else {
            for (int i = l; i < m; i++) {
                tmp[count++] = nums1[i];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            nums1[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;
        new Solution().merge(nums1, m, nums2, n);
    }
}
