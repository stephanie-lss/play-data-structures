package com;

import java.util.List;

/**
 * @author LiSheng
 * @date 2020/4/7 17:36
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this(val);
        this.children = children;
    }
}
