package com.solution232;

import java.util.Stack;

class MyQueue {

    public Stack<Integer> stack;
    public int size;
    public Stack<Integer> newStack = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack = new Stack<>();
        size = 0;
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.push(x);
        size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (newStack.isEmpty()) {
            for (int i = 0; i < size; i++) {
                newStack.push(stack.pop());
            }
        }
        size--;
        return newStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (newStack.isEmpty()) {
            for (int i = 0; i < size; i++) {
                newStack.push(stack.pop());
            }
        }
        return newStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop()); // 返回 1
        System.out.println(queue.peek());// 返回 1
        System.out.println(queue.empty());// 返回 false
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */