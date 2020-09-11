package com.solution222;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/2/25 21:22
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
