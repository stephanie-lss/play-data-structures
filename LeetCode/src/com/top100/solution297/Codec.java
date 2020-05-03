package com.top100.solution297;

import com.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/3 18:37
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left);
                    sb.append(node.left.val).append(" ");
                } else {
                    queue.offer(null);
                    sb.append("null").append(" ");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    sb.append(node.right.val).append(" ");
                } else {
                    queue.offer(null);
                    sb.append("null").append(" ");
                }
            }
        }
        String[] s = sb.toString().trim().split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            if ("null".equals(s[i])) {
                s[i] = "";
            } else {
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        for (String s1 : s) {
            res.append(s1).append(" ");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] strings = data.split(" ");
        return buildTree(strings);
    }

    private TreeNode buildTree(String[] strings) {
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        TreeNode ret = root;
        boolean flag = true;
        int count = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        for (int i = 1; i < strings.length; i++) {
            if (count == 2) {
                root = list.removeFirst();
                count = 0;
            }
            if (flag) {
                if (!"null".equals(strings[i])) {
                    root.left = new TreeNode(Integer.parseInt(strings[i]));
                    list.add(root.left);
                } else {
                    root.left = null;
                }
                flag = false;
            } else {
                if (!"null".equals(strings[i])) {
                    root.right = new TreeNode(Integer.parseInt(strings[i]));
                    list.add(root.right);
                } else {
                    root.right = null;
                }
                flag = true;
            }
            count++;
        }
        return ret;
    }
}
