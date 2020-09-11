package com.offer.interview57_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/13 15:26
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int end = target / 2 + 1;
        for (int left = 1, right = 2; right <= end; ) {
            int tmp = (right + left) * (right - left + 1) / 2;
            if (tmp == target) {
                int[] arr = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                right++;
            } else if (tmp < target) {
                right++;
            } else {
                left++;
                if (right != left + 1) {
                    right--;
                }
            }
        }
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int target = 9;
        new Solution().findContinuousSequence(target);
    }
}