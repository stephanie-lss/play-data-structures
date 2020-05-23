package com.offer.interview37;

import com.TreeNode;
import com.tree.ConstructTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/23 15:41
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val +
                "," + serialize(root.left) +
                "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strings = data.split(",");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(strings));
        return reSerialize(list);
    }

    private TreeNode reSerialize(LinkedList<String> list) {
        if ("#".equals(list.getFirst())) {
            list.removeFirst();
            return null;
        }
        String str = list.removeFirst();
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = reSerialize(list);
        root.right = reSerialize(list);
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, null, 4, 5};
        TreeNode tree = ConstructTree.constructTree(nums);
        System.out.println(new Codec().serialize(tree));
    }
}