package com.interview.solution3_4;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/26 8:42
 */
class MyQueue {

    private LinkedList<Integer> inStack;
    private LinkedList<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.addLast(inStack.removeLast());
            }
        }
        return outStack.removeLast();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.addLast(inStack.removeLast());
            }
        }
        return outStack.getLast();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}