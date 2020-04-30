package com.top100.solution4;

/**
 * @author LiSheng
 * @date 2020/4/30 9:41
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int pre = -1, cur = -1;
        int p1 = 0, p2 = 0;
        for (int i = 0; i <= n / 2; i++) {
            pre = cur;
            if ((p1 < nums1.length && nums1[p1] < nums2[p2]) || p2 >= nums2.length) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
        }
        if ((n & 1) == 1) {
            return cur;
        } else {
            return pre + cur;
        }
    }
}
