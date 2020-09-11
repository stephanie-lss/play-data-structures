package com.offer.interview30;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/16 16:42
 */
class MinStack {

    private class Node {
        private int val;
        private int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    LinkedList<Node> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.addLast(new Node(x, x));
        } else {
            if (stack.getLast().min > x) {
                stack.addLast(new Node(x, x));
            } else {
                stack.addLast(new Node(x, stack.getLast().min));
            }
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