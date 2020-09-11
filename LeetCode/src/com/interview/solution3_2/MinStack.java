package com.interview.solution3_2;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/25 14:24
 */
class MinStack {
    private LinkedList<int[]> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.addLast(new int[]{x, x});
        } else {
            if (stack.getLast()[1] >= x) {
                stack.addLast(new int[]{x, x});
            } else {
                stack.addLast(new int[]{x, stack.getLast()[1]});
            }
        }
    }

    public void pop() {
        stack.removeLast();
    }

    public int top() {
        return stack.getLast()[0];
    }

    public int getMin() {
        return stack.getLast()[1];
    }
}