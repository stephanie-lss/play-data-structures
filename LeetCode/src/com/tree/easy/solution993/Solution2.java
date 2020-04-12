package com.tree.easy.solution993;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/7 21:33
 */
public class Solution2 {
    List<Integer> list = new ArrayList<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new AbstractMap.SimpleEntry<>(root, 1));

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> entry = queue.poll();
            root = entry.getKey();
            if (root.left != null && root.right != null) {
                if (root.left.val == x && root.right.val == y || root.left.val == y && root.right.val == x) {
                    return false;
                }
            }
            Integer curDepth = entry.getValue();
            if (x == root.val) {
                list.add(curDepth);
            }
            if (y == root.val) {
                list.add(curDepth);
            }
            if (root.left != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(root.left, curDepth + 1));
            }
            if (root.right != null) {
                queue.offer(new AbstractMap.SimpleEntry<>(root.right, curDepth + 1));
            }
        }
        if (list.size() < 2) {
            return false;
        }
        return list.get(0).equals(list.get(1));
    }
}
