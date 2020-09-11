package com.tree.easy.solution589;

import com.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 18:29
 */
public class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null){
            return res;
        }
        preOrder(root);
        return res;
    }

    private void preOrder(Node node) {
        if (node == null){
            return;
        }
        res.add(node.val);
        for (Node child : node.children) {
            preorder(child);
        }
    }
}
