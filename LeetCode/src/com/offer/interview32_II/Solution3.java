package com.offer.interview32_II;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/4 10:55
 */
public class Solution3 {
    private List<List<Integer>> ret;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    private void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (ret.size() == depth) {
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(root.val);
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }
}
