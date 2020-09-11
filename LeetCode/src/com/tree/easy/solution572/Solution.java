package com.tree.easy.solution572;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/6 20:45
 */
public class Solution {
    Set<String> tSet = new HashSet<>();
    List<Integer> tTmp = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        allInOrder(s);
        inOrder(t);
        return tSet.contains(Arrays.toString(tTmp.toArray()));
    }

    //统计以root为根节点的二叉树中的所有节点的中序遍历的情况
    private void allInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root);
        tSet.add(Arrays.toString(tTmp.toArray()));
        tTmp.clear();

        if (root.left != null) {
            allInOrder(root.left);
        }
        if (root.right != null) {
            allInOrder(root.right);
        }
    }

    private void inOrder(TreeNode t) {
        if (t == null) {
            return;
        }
        inOrder(t.left);
        tTmp.add(t.val);
        inOrder(t.right);
    }
}
