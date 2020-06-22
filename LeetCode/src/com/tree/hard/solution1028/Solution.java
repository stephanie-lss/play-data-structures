package com.tree.hard.solution1028;

import com.TreeNode;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/6/18 8:39
 */
public class Solution {
    private class Node {
        private TreeNode node;
        //判断左右子树的标志，true表示左孩子为空
        private boolean isLeft;

        public Node(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        //key-节点的深度，value-节点
        Map<Integer, Node> record = new HashMap<>();
        //初始条件
        int depth = 0;
        for (int i = 0; i < S.length(); ) {
            if (S.charAt(i) != '-') {
                //从i开始，找到下一次出现‘-’前的数字
                StringBuilder sb = new StringBuilder();
                while (i < S.length() && S.charAt(i) != '-') {
                    sb.append(S.charAt(i++));
                }
                int value = Integer.parseInt(sb.toString());

                if (depth != 0) {
                    //找到第depth-1层，也就是父亲节点的深度
                    Node parent = record.get(depth - 1);
                    //判断父节点左子树是否已经存在节点
                    if (parent.isLeft) {
                        //不存在，将该节点作为该父亲节点的左孩子
                        parent.node.left = new TreeNode(value);
                        //此时该父亲节点只有右孩子为空
                        parent.isLeft = false;
                        //保存到Map中
                        record.put(depth, new Node(parent.node.left, true));
                    } else {
                        //存在就放到右子树上去
                        parent.node.right = new TreeNode(value);
                        //保存到Map中
                        record.put(depth, new Node(parent.node.right, true));
                    }
                } else {
                    //此时为根节点，直接保存到Map中即可
                    record.put(depth, new Node(new TreeNode(value), true));
                }
                //此节点已经还原到了二叉树中，深度清零
                depth = 0;
            } else {
                //直接深度+1
                depth++;
                //索引也后移一位
                i++;
            }
        }
        //返回深度为0的节点
        return record.get(0).node;
    }

    public static void main(String[] args) {
        String S = "1-2--3--4-5--6--7";
        new Solution().recoverFromPreorder(S);
    }
}
