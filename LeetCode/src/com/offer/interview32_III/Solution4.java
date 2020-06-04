package com.offer.interview32_III;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/4 11:06
 */
public class Solution4 {
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
            ret.add(new LinkedList<>());
        }
        if ((depth & 1) == 1) {
            ret.get(depth).add(0, root.val);
        } else {
            ret.get(depth).add(root.val);
        }
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }
}
