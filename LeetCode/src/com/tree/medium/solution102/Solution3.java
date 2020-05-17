package com.tree.medium.solution102;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/13 15:14
 */
public class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int index, List<List<Integer>> res) {
        if (res.size() == index) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        if (root.left != null) {
            dfs(root.left, index + 1, res);
        }
        if (root.right != null) {
            dfs(root.right, index + 1, res);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = ConstructTree.constructTree(nums);
        new Solution3().levelOrder(root);
    }
}
