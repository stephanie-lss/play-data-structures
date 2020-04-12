package com.tree.easy.solution590;

import com.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 19:02
 */
public class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return null;
        }

        postOrder(root);
        return res;
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        for (Node child : node.children) {
            postorder(child);
        }
        res.add(node.val);
    }
}
