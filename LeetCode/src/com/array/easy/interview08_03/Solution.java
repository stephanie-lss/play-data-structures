package com.array.easy.interview08_03;

/**
 * @author LiSheng
 * @date 2020/4/1 14:57
 */
public class Solution {
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i){
                return i;
            }
        }
        return -1;
    }
}
