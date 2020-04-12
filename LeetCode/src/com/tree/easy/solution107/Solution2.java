package com.tree.easy.solution107;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/2/23 15:45
 */
public class Solution2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode top = queue.poll();
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
                tmp.add(top.val);
            }
            res.addFirst(tmp);
        }
        return res;
    }
}
