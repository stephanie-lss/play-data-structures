package com.solution107;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/2/23 15:45
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode delNode = queue.remove();
                nums.add(delNode.val);
                if (delNode.left != null) {
                    queue.add(delNode.left);
                }
                if (delNode.right != null) {
                    queue.add(delNode.right);
                }
            }
            res.addFirst(nums);
        }
        return res;
    }
}
