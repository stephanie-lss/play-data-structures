package com.solution155;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/5/12 14:40
 */
class MinStack3 {

    private Stack<Node> stack;

    private class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack3() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (!stack.isEmpty()) {
            stack.push(new Node(x, Math.min(x, stack.peek().min)));
        } else {
            stack.push(new Node(x, x));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
    public static void main(String[] args) {
        MinStack3 minStack = new MinStack3();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.top();
        minStack.pop();
        minStack.getMin();
    }
}