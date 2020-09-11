package com.top100.solution4;

/**
 * @author LiSheng
 * @date 2020/4/30 10:27
 */
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int temp = m;
            m = n;
            n = temp;
        }

        int iMin = 0, iMax = m + 1;
        while (iMin < iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((len & 1) == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int[] nums2 = {2, 3};
        System.out.println(new Solution2().findMedianSortedArrays(nums, nums2));
    }
}