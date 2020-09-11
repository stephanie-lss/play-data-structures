package com.solution129;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 10:30
 */
public class Solution {
    List<String> path = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        int res = 0;
        for (String p : path) {
            res += Integer.valueOf(p);
        }
        return res;
    }

    private void dfs(TreeNode root, String s) {
        String str = "";
        if (root == null) {
            return;
        }
        str += s + root.val;
        if (root.left == null && root.right == null) {
            path.add(str);
        }

        if (root.left != null) {
            dfs(root.left, str);
        }

        if (root.right != null) {
            dfs(root.right, str);
        }
    }
}
