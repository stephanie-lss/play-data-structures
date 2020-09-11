package com.solution103;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/2/25 16:16
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag){
                Collections.reverse(list);
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}
