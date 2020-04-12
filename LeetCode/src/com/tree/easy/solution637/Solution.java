package com.tree.easy.solution637;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/7 10:38
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ave = new ArrayList<>();
        if (root == null){
            return ave;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0.0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ave.add((sum / count));
        }
        return ave;
    }
}
