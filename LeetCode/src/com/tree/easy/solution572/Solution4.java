package com.tree.easy.solution572;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/5/7 16:26
 */
class Solution4 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return s == null;
        }
        if (s == null) {
            return false;
        }
        return compare(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean compare(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s != null && t == null) {
            return false;
        }
        if (s == null) {
            return false;
        }
        return s.val == t.val && compare(s.left, t.left) && compare(s.right, t.right);
    }
}