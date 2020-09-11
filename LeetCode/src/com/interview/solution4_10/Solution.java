package com.interview.solution4_10;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/6/27 12:52
 */
class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return isSubTree(t1, t2);
    }

    private boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null && t1 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val == t2.val && isSubTree(t1.left, t2.left) && isSubTree(t1.right, t2.right)) {
            return true;
        }
        return isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
    }
}