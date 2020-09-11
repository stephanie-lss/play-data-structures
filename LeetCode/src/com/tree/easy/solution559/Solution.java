package com.tree.easy.solution559;

import com.Node;

/**
 * @author LiSheng
 * @date 2020/4/7 17:35
 */
class Solution {
    int max = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            for (Node child : root.children) {
                max = Math.max(max, maxDepth(child) + 1);
            }
        }
        return max;
    }

}