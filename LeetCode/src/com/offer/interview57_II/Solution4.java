package com.offer.interview57_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/16 10:05
 */
public class Solution4 {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, end = target / 2;
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        while (left <= end) {
            sum += right;
            right++;
            while (sum > target) {
                sum -= left;
                left++;
            }
            if (sum == target) {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                list.add(arr);
                sum -= left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
    public static void main(String[] args) {
        int target = 9;
        new Solution4().findContinuousSequence(target);
    }
}
