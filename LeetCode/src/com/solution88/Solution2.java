package com.solution88;

/**
 * @author LiSheng
 * @date 2020/2/23 14:54
 */
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length - 1;
        int r = nums2.length - 1;
        int nl = m - 1;
        while (nl >= 0 && r >= 0) {
            if (nums1[nl] < nums2[r]) {
                nums1[l--] = nums2[r--];
            } else if (nums1[nl] > nums2[r]) {
                nums1[l--] = nums1[nl--];
            } else {
                nums1[l--] = nums1[nl--];
                nums1[l--] = nums2[r--];
            }
        }
        if (nl < 0) {
            for (int i = r; i >= 0; i--) {
                nums1[l--] = nums2[i];
            }
        } else {
            for (int i = nl; i >= 0; i--) {
                nums1[i] = nums1[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0, 0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        new Solution2().merge(nums1, m, nums2, n);
    }
}
