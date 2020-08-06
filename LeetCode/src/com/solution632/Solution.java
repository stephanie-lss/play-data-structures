package com.solution632;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/8/1 12:32
 */
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer index1, Integer index2) {
                return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 10, 15, 24, 26));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(0, 9, 12, 20));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(5, 18, 22, 30));
        nums.add(list1);
        nums.add(list2);
        nums.add(list3);
        int[] res = solution.smallestRange(nums);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
}
