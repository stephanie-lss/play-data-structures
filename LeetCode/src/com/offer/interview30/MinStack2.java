package com.offer.interview30;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/4 9:59
 */
public class MinStack2 {
    private class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private LinkedList<Node> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x < stack.getLast().min) {
            stack.addLast(new Node(x, x));
        } else {
            stack.addLast(new Node(x, stack.getLast().min));
        }
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast().val;
    }

    public int min() {
        return stack.getLast().min;
    }
}
