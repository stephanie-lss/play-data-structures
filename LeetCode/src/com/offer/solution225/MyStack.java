package com.offer.solution225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/7/3 11:07
 */
class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (!queue1.isEmpty()) {
            Integer poll = queue1.poll();
            if (queue1.isEmpty()) {
                return poll;
            }
            queue2.offer(poll);
        }
        while (!queue2.isEmpty()) {
            Integer poll = queue2.poll();
            if (queue2.isEmpty()) {
                return poll;
            }
            queue1.offer(poll);
        }
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (!queue1.isEmpty()) {
            Integer poll = queue1.poll();
            queue2.offer(poll);
            if (queue1.isEmpty()) {
                return poll;
            }
        }
        while (!queue2.isEmpty()) {
            Integer poll = queue2.poll();
            queue1.offer(poll);
            if (queue2.isEmpty()) {
                return poll;
            }
        }
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}