package com.offer.interview32_II;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/13 15:24
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int index) {
        if (res.size() == index) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        if (root.left != null) {
            dfs(root.left, index + 1);
        }
        if (root.right != null) {
            dfs(root.right, index + 1);
        }
    }

    public static void main(String[] args) {
        String s1 = "li";
        String s2 = "li";
        Integer n1 = 128;
        Integer n2 = 128;
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));
    }
}