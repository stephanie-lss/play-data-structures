package com.tree.easy.solution671;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/7 12:48
 */
public class Solution {
    Set<Integer> set = new TreeSet<>((o1, o2) -> o2 - o1);

    public int findSecondMinimumValue(TreeNode root) {
        inOrder(root);
        if (set.size() <= 1) {
            return -1;
        } else {
            Iterator<Integer> iterator = set.iterator();
            iterator.next();
            return iterator.next();
        }
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        set.add(node.val);
        inOrder(node.right);
    }
}
