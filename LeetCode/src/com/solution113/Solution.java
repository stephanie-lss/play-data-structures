package com.solution113;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/26 10:13
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.right == null && root.left == null) {
            if (root.val == sum) {
                list.add(root.val);
                res.add(list);
                return res;
            }
        }
        if (root.left != null) {
            List<List<Integer>> leftPath = pathSum(root.left, sum - root.val);
            for (int i = 0; i < leftPath.size(); i++) {
                List<Integer> e = leftPath.get(i);
                e.add(0, root.val);
                res.add(e);
            }
        }
        if (root.right != null) {
            List<List<Integer>> rightPath = pathSum(root.right, sum - root.val);
            for (int i = 0; i < rightPath.size(); i++) {
                List<Integer> e = rightPath.get(i);
                e.add(0, root.val);
                res.add(e);
            }
        }
        return res;
    }
}
