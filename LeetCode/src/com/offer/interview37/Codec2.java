package com.offer.interview37;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/6 10:54
 */
public class Codec2 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] strings = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return helper(list);
    }

    private TreeNode helper(LinkedList<String> list) {
        if ("#".equals(list.getFirst())) {
            list.removeFirst();
            return null;
        }
        String s = list.removeFirst();
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(list);
        root.right = helper(list);
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, null, 4, 5};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Codec2().serialize(root));
    }
}