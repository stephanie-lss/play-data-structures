package com.top100.solution297;

import com.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/3 19:41
 */
public class Codec2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",").append(serialize(root.left));
        sb.append(",").append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        return reSerialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    private TreeNode reSerialize(LinkedList<String> dataList) {
        if ("#".equals(dataList.get(0))) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = reSerialize(dataList);
        root.right = reSerialize(dataList);
        return root;
    }
}
