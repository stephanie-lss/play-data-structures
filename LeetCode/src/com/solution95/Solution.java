package com.solution95;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/21 10:37
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int l, int r) {
        List<TreeNode> tree = new ArrayList<>();
        if (l > r) {
            tree.add(null);
            return tree;
        }
        //遍历可能的根节点
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTree = dfs(l, i - 1);
            List<TreeNode> rightTree = dfs(i + 1, r);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    tree.add(root);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                }
            }
        }
        return tree;
    }

    public static void main(String[] args) {
        new Solution().generateTrees(3);
    }
}
