package com.top100.solution128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/6 9:11
 */
public class Solution4 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!record.containsKey(num)) {
                if (record.containsKey(num - 1) && record.containsKey(num + 1)) {
                    int leftCount = record.get(num - 1);
                    int rightCount = record.get(num + 1);
                    record.put(num, leftCount + rightCount + 1);
                    //维护连续序列的长度
                    for (int i = num - leftCount; i < num; i++) {
                        record.put(i, record.get(num));
                    }
                    for (int i = num + 1; i <= num + rightCount; i++) {
                        record.put(i, record.get(num));
                    }
                } else if (record.containsKey(num - 1)) {
                    int leftCount = record.get(num - 1);
                    record.put(num, leftCount + 1);
                    for (int i = num - leftCount; i < num; i++) {
                        record.put(i, record.get(num));
                    }
                } else if (record.containsKey(num + 1)) {
                    int rightCount = record.get(num + 1);
                    record.put(num, rightCount + 1);
                    for (int i = num + 1; i <= num + rightCount; i++) {
                        record.put(i, record.get(num));
                    }
                } else {
                    record.put(num, 1);
                }
                max = Math.max(max, record.get(num));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new Solution4().longestConsecutive(nums));
    }
}
