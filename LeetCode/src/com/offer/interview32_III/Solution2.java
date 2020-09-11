package com.offer.interview32_III;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/15 21:04
 */
public class Solution2 {
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        for (int i = 0; i < res.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (index == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        dfs(root.left, index + 1);
        dfs(root.right, index + 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Solution2().levelOrder(root));
    }
}
