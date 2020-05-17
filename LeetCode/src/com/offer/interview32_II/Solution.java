package com.offer.interview32_II;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/13 15:24
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (res.size() == index) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        if (root.left != null) {
            dfs(root.left, index + 1);
        }
        if (root.right != null) {
            dfs(root.right, index + 1);
        }
    }
}