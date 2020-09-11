package com.offer.interview37;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/16 8:37
 */
public class Codec3 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return reSerialize(list);
    }

    private TreeNode reSerialize(LinkedList<String> list) {
        if ("#".equals(list.getFirst())) {
            list.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.removeFirst()));
        root.left = reSerialize(list);
        root.right = reSerialize(list);
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, null, 4, 5};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(new Codec3().serialize(root));
    }
}
