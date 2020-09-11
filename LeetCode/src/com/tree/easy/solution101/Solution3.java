package com.tree.easy.solution101;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/31 12:25
 */
public class Solution3 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    level.add(root.left.val);
                    queue.add(root.left);
                } else {
                    level.add(Integer.MIN_VALUE);
                }
                if (root.right != null) {
                    level.add(root.right.val);
                    queue.add(root.right);
                } else {
                    level.add(Integer.MIN_VALUE);
                }
            }
            if (!isCircle(level)) {
                return false;
            }
            level.clear();
        }
        return true;
    }

    private boolean isCircle(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,2,null,3,null,3};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution3().isSymmetric(root));
    }
}
