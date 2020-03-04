package com.solution66;

import java.util.Arrays;

/**
 * @author LiSheng
 * @date 2020/2/23 11:35
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int k = 0;
        for (k = 0; k < digits.length; k++) {
            if (digits[k] != 9) {
                break;
            }
        }
        if (k == digits.length) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }
        digits[digits.length - 1] = 0;
        int[] res = plusOne(Arrays.copyOfRange(digits, 0, digits.length - 1));
        for (int i = 0; i < res.length; i++) {
            digits[i] = res[i];
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9};
        int[] ints = new Solution().plusOne(nums);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
