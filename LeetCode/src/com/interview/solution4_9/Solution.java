package com.interview.solution4_9;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/27 12:14
 */
public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> BSTSequences(TreeNode root) {
        this.res = new ArrayList<>();
        if (root == null) {
            res.add(new ArrayList<>());
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        dfs(root, new ArrayList<>(), path);
        return res;
    }

    private void dfs(TreeNode root, List<TreeNode> list, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            list.add(root.left);
        }
        if (root.right != null) {
            list.add(root.right);
        }
        if (list.isEmpty()) {
            res.add(new LinkedList<>(path));
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TreeNode del = list.remove(i);
            path.addLast(del.val);
            dfs(del, list, path);
            path.removeLast();
            list.add(i, del);
        }
    }
}
