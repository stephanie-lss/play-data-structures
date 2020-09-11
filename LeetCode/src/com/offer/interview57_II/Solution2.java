package com.offer.interview57_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/13 16:35
 */
public class Solution2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0, end = target / 2;
        List<int[]> res = new ArrayList<>();
        while (left <= end) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int target = 9;
        new Solution2().findContinuousSequence(target);
    }
}
