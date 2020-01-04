package com.solution938;

import com.TreeNode;

/**
 * @author LiSheng
 * @date 2020/1/4 10:46
 */
public class BinaryTree {
    public TreeNode root;
    public int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }



    public void add(Integer e) {
        /*if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }*/
        root = add(root, e);
    }

    /**
     * 向一node为根的二分搜索树中插入元素e，递归算法
     * 返回新插入节点后二分搜索树的根
     *
     * @param node
     * @param e
     */
    private TreeNode add(TreeNode node, Integer e) {
        /*if (node.e.equals(e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }*/
        if (node == null) {
            size++;
            return new TreeNode(e);
        }
        if (e.compareTo(node.val) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.val) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(TreeNode node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.val + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
