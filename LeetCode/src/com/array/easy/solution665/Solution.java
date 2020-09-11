package com.array.easy.solution665;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/3/30 12:50
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        if (isIncreaseArray(list) || isIncreaseArray(list.subList(1, list.size())) || isIncreaseArray(list.subList(0, list.size() - 1))) {
            return true;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (isIncreaseArray(list.subList(0, i))){
                if (isIncreaseArray(list.subList(i + 1, list.size())) && list.get(i - 1) <= list.get(i + 1)) {
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    private boolean isIncreaseArray(List<Integer> nums) {
        if (nums.isEmpty()) {
            return true;
        }
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 4};
        new Solution().checkPossibility(nums);
    }
}
