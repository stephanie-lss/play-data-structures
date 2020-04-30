package com.solution275;

/**
 * @author LiSheng
 * @date 2020/4/29 21:22
 */
class Solution {
    public int hIndex(int[] citations) {
        for (int i = citations.length; i >= 0; i--) {
            int left = 0;
            int right = citations.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (citations[mid] > i) {
                    right = mid;
                } else if (citations[mid] < i) {
                    left = mid + 1;
                } else if (citations[mid] == i) {
                    right = mid;
                }
            }
            if (left == citations.length) {
                continue;
            }
            if (citations.length - left >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] cit = {0, 1, 3, 5, 6};
        System.out.println(new Solution().hIndex(cit));
    }
}
