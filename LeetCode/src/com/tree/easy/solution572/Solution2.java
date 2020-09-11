package com.tree.easy.solution572;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/4/6 20:45
 */
public class Solution2 {
    List<Integer> tTmp = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        inOrder(t);
        List<Integer> inOrderT = new ArrayList<>(tTmp);
        System.out.println(inOrderT);
        tTmp.clear();

        inOrder(s);
        List<Integer> inOrderS = new ArrayList<>(tTmp);
        System.out.println(inOrderS);
        tTmp.clear();

        if (Arrays.toString(inOrderT.toArray()).equals(Arrays.toString(inOrderS.toArray()))) {
            System.out.println("if AAA");
            return true;
        }

        return (s.right != null && isSubtree(s.right, t)) || (s.left != null && isSubtree(s.left, t));
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        tTmp.add(node.val);
        inOrder(node.right);
    }
}
