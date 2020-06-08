package com.offer.interview34;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/5 8:59
 */
public class Solution2 {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.res = new ArrayList<>();
        dfs(root, sum, new LinkedList<>());
        return res;
    }

    private void dfs(TreeNode root, int sum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
            list.removeLast();
            return;
        }
        dfs(root.left, sum, list);
        dfs(root.right, sum, list);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = ConstructTree.constructTree(nums);
        new Solution2().pathSum(root, 22);
    }
}
