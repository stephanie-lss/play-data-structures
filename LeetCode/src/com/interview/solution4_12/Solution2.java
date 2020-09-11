package com.interview.solution4_12;

import com.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/6/27 13:14
 */
class Solution2 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> prefixMax = new HashMap<>();
        prefixMax.put(0, 1);
        return calPathSum(root, prefixMax, sum, 0);
    }


    private int calPathSum(TreeNode root, Map<Integer, Integer> prefixMap, int sum, int curSum) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int tmp = 0;
        tmp += prefixMap.getOrDefault(curSum - sum, 0);
        prefixMap.put(curSum, prefixMap.getOrDefault(curSum, 0) + 1);
        tmp += calPathSum(root.left, prefixMap, sum, curSum) + calPathSum(root.right, prefixMap, sum, curSum);
        prefixMap.put(curSum, prefixMap.get(curSum) - 1);
        return tmp;
    }
}