package com.offer.interview34;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/16 19:54
 */
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        dfs(root, sum, 0, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, int count, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        count += root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (count == sum) {
                res.add(new LinkedList<>(list));
            }
        }
        dfs(root.left, sum, count, list);
        dfs(root.right, sum, count, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = ConstructTree.constructTree(nums);
        new Solution().pathSum(root, 22);
    }
}