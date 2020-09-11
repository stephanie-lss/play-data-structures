package com.tree.medium.solution1315;

import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/4/30 20:07
 */
class Solution2 {
    int sum = 0;

    private class Helper {
        private TreeNode node;
        private boolean need;

        public Helper(TreeNode node, boolean need) {
            this.node = node;
            this.need = need;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return sum;
        }
        Queue<Helper> queue = new LinkedList<>();
        queue.offer(new Helper(root, false));
        while (!queue.isEmpty()) {
            Helper helper = queue.poll();
            if (helper.node.left != null) {
                if (helper.need) {
                    sum += helper.node.left.val;
                }
                if ((helper.node.val & 1) == 0) {
                    queue.offer(new Helper(helper.node.left, true));
                } else {
                    queue.offer(new Helper(helper.node.left, false));
                }
            }
            if (helper.node.right != null) {
                if (helper.need) {
                    sum += helper.node.right.val;
                }
                if ((helper.node.val & 1) == 0) {
                    queue.offer(new Helper(helper.node.right, true));
                } else {
                    queue.offer(new Helper(helper.node.right, false));
                }
            }
        }
        return sum;
    }
}
