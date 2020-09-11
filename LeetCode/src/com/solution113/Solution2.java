package com.solution113;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 10:13
 */
public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, sum);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(list));
            }
        }
        if (root.left != null) {
            dfs(root.left, list, sum);
        }

        if (root.right != null) {
            dfs(root.right, list, sum);
        }
        list.remove(list.size()-1);
    }
}
