package com.tree.easy.solution501;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/6 17:15
 */
public class Solution2 {
    List<Integer> freq = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int count = 0;
    Integer pre = null;

    public int[] findMode(TreeNode root) {
        inOrder(root);

        int[] res = new int[freq.size()];
        int idx = 0;
        for (Integer i : freq) {
            res[idx++] = i;
        }
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);

        if (pre != null && node.val == pre) {
            count++;
        } else {
            count = 1;
        }
        if (count == max) {
            freq.add(node.val);
        }

        if (count > max) {
            max = count;
            freq.clear();
            freq.add(node.val);
        }
        pre = node.val;
        inOrder(node.right);
    }
}
