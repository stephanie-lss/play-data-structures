package com.tree.easy.solution257;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 9:20
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (null == root.left && null == root.right) {
            res.add(String.valueOf(root.val));
            return res;
        }
        if (null != root.left) {
            List<String> leftPath = binaryTreePaths(root.left);
            for (int i = 0; i < leftPath.size(); i++) {
                res.add(root.val + "->" + leftPath.get(i));
            }
        }
        if (null != root.right) {
            List<String> rightPath = binaryTreePaths(root.right);
            for (int i = 0; i < rightPath.size(); i++) {
                res.add(root.val + "->" + rightPath.get(i));
            }
        }
        return res;
    }
}
