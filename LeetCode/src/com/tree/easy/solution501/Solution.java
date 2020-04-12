package com.tree.easy.solution501;

import com.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiSheng
 * @date 2020/4/6 17:15
 */
public class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        preOrder(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (Integer i : list) {
            res[idx++] = i;
        }
        return res;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        freq.put(node.val, freq.getOrDefault(node.val, 0) + 1);
        if (max < freq.get(node.val)) {
            max = freq.get(node.val);
        }
        preOrder(node.left);
        preOrder(node.right);
    }
}
