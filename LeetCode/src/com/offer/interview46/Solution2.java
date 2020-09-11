package com.offer.interview46;

/**
 * @author LiSheng
 * @date 2020/5/19 14:36
 */
public class Solution2 {
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        int last = num % 100;
        if (last > 25 || last <= 9) {
            return translateNum(num / 10);
        }
        return translateNum(num / 100) + translateNum(num / 10);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().translateNum(1225));
    }
}
