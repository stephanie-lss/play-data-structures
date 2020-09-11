package com.solution144;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/2/25 15:01
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
