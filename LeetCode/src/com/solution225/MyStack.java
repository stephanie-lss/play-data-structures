package com.solution225;

import java.util.ArrayList;

class MyStack {
    public ArrayList<Integer> arrayList;
    public int size;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        arrayList = new ArrayList<>();
        size = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        arrayList.add(x);
        size++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!arrayList.isEmpty()) {
            return arrayList.remove(--size);
        }
        return 0;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!arrayList.isEmpty()) {
            return arrayList.get(size - 1);
        }
        return 0;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        System.out.println(param_2);
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */