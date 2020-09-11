package com.tree.medium.solution102;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/2/25 15:33
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.remove();
                list.add(node.val);
                count--;
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

}
