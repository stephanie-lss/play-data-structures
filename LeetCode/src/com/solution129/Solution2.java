package com.solution129;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 10:30
 */
public class Solution2 {
    List<String> path = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        int res = 0;
        for (String p : path) {
            res += Integer.valueOf(p);
        }
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return;
        }
        builder.append(sb.toString()).append(root.val);
        if (root.left == null && root.right == null) {
            path.add(builder.toString());
        }

        if (root.left != null) {
            dfs(root.left, builder);
        }

        if (root.right != null) {
            dfs(root.right, builder);
        }
    }
}
