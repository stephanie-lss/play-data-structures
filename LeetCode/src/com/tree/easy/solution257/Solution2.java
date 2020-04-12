package com.tree.easy.solution257;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 9:20
 */
public class Solution2 {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {
        String newStr = s;
        if (root == null) {
            return;
        }

        newStr += "".equals(s) ? root.val : "->" + root.val;
        if (root.left == null && root.right == null) {
            res.add(newStr);
        }
        if (root.left != null) {
            dfs(root.left, newStr);
        }
        if (root.right != null) {
            dfs(root.right, newStr);
        }
    }
}
