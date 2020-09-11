package com.offer.interview33;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/5/19 15:33
 */
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return leftRightRoot(postorder);
    }

    //[0,rightIdx - 1]
    //[rightIdx,rootIdx-1]
    //[rootIdx]
    private boolean leftRightRoot(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }
        int rightIdx;
        for (rightIdx = n - 2; rightIdx >= 0; rightIdx--) {
            if (nums[rightIdx] < nums[n - 1]) {
                rightIdx++;
                break;
            }
        }
        if (rightIdx == -1) {
            return leftRightRoot(Arrays.copyOfRange(nums, rightIdx + 1, n - 1));
        }
        for (int i = 0; i < rightIdx; i++) {
            if (nums[i] > nums[n - 1]) {
                return false;
            }
        }
        return leftRightRoot(Arrays.copyOfRange(nums, 0, rightIdx)) && leftRightRoot(Arrays.copyOfRange(nums, rightIdx, n - 1));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 10, 6, 9, 4, 3};
        System.out.println(new Solution().verifyPostorder(nums));
    }
}