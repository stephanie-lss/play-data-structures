package com.interview.solution1_1;

/**
 * @author LiSheng
 * @date 2020/6/23 10:43
 */
public class Solution2 {
    public boolean isUnique(String astr) {
        int mark = 0;
        for (int i = 0; i < astr.length(); i++) {
            int num = 1 << (astr.charAt(i) - 'a');
            if ((mark & num) != 0) {
                return false;
            } else {
                mark |= num;
            }
        }
        return true;
    }
}
