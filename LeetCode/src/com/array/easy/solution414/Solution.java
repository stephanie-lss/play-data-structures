package com.array.easy.solution414;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/3/28 20:59
 */
class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> s = new TreeSet<>();
        for (int num : nums) {
            s.add(num);
        }

        Iterator<Integer> iterator = s.iterator();
        int[] arr = new int[s.size()];
        int index = 0;
        while (iterator.hasNext()) {
            arr[index++] = iterator.next();
        }
        return arr.length < 3 ? arr[arr.length - 1] : arr[arr.length - 3];
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, 1, 1};
        System.out.println(new Solution().thirdMax(nums));
    }
}