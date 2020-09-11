package com.offer.interview27;

import com.TreeNode;
import com.offer.TreeLevel;
import com.tree.ConstructTree;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/6/3 16:44
 */
class Solution3 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root != null) {
                    level.add(root.val);
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else {
                    level.add(Integer.MIN_VALUE);
                }
            }
            Collections.reverse(level);
            res.add(new ArrayList<>(level));
            level.clear();
        }
        root = new TreeNode(res.get(0).get(0));
        TreeNode ret = root;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean flag = true;
        int count = 0;
        int idx = 1;
        while (idx!=res.size()) {
            List<Integer> level = res.get(idx++);
            for (int i = 0; i < level.size(); i++) {
                if (count % 2 == 0) {
                    root = list.removeFirst();
                }
                Integer c = level.get(i);
                if (flag) {
                    count++;
                    if (!c.equals(Integer.MIN_VALUE)) {
                        root.left = new TreeNode(c);
                        list.add(root.left);
                    } else {
                        root.left = null;
                    }
                    flag = false;
                } else {
                    count++;
                    if (!c.equals(Integer.MIN_VALUE)) {
                        root.right = new TreeNode(c);
                        list.add(root.right);
                    } else {
                        root.right = null;
                    }
                    flag = true;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer[] nums = {4, 2, 7, 1, null, 6, 9};
        TreeNode root = ConstructTree.constructTree(nums);
        root = new Solution3().mirrorTree(root);
        List<Integer> res = TreeLevel.levelOrder(root);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
}