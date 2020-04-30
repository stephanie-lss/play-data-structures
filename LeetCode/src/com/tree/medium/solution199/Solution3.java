package com.tree.medium.solution199;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/22 10:15
 */
class Solution3 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(root.val);
        }
        dfs(list, root.right, depth + 1);
        dfs(list, root.left, depth + 1);
    }
}
