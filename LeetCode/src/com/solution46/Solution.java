package com.solution46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 20:14
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        findPermute(nums, 0, list);
        return res;
    }

    private void findPermute(int[] nums, int index, LinkedList<Integer> list) {
        System.out.println("index->" + index);
        if (index == nums.length) {
            System.out.println("res add list");
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                System.out.println("used:" + nums[i] + ";i->" + i);
                list.add(nums[i]);
                used[i] = true;
                findPermute(nums, index + 1, list);
                System.out.println("remove:" + list.getLast()+ ";i->" + i);
                list.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().permute(nums);
    }
}
