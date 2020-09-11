package com.interview.solution3_5;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/26 8:55
 */
class SortedStack {

    private LinkedList<Integer> tmpStack;

    public SortedStack() {
        this.tmpStack = new LinkedList<>();
    }

    public void push(int val) {
        if (tmpStack.isEmpty() || val <= tmpStack.getLast()) {
            tmpStack.addLast(val);
            return;
        }
        LinkedList<Integer> tmp = new LinkedList<>();
        while (!tmpStack.isEmpty() && tmpStack.getLast() < val) {
            tmp.addLast(tmpStack.removeLast());
        }
        tmpStack.addLast(val);
        while (!tmp.isEmpty()) {
            tmpStack.addLast(tmp.removeLast());
        }
    }

    public void pop() {
        if (!tmpStack.isEmpty()) {
            tmpStack.removeLast();
        }
    }

    public int peek() {
        if (tmpStack.isEmpty()) {
            return -1;
        }
        return tmpStack.getLast();
    }

    public boolean isEmpty() {
        return tmpStack.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
