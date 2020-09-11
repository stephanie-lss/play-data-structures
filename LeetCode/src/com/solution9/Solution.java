package com.solution9;

/**
 * @author LiSheng
 * @date 2020/6/10 9:41
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverNum = 0;
        int num = x;
        while (x != 0) {
            reverNum = reverNum * 10 + x % 10;
            x /= 10;
        }
        return reverNum == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}