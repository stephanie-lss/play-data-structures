package com.interview.solution3_5;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/26 8:55
 */
class SortedStack2 {

    private LinkedList<Integer> tmpStack;
    private LinkedList<Integer> tmp;

    public SortedStack2() {
        this.tmpStack = new LinkedList<>();
        this.tmp = new LinkedList<>();
    }

    public void push(int val) {
        if (tmpStack.isEmpty() && tmp.isEmpty()) {
            tmpStack.addLast(val);
            return;
        }
        while (!tmp.isEmpty() && !tmpStack.isEmpty() && tmp.getLast() >= tmpStack.getLast()) {
            tmpStack.addLast(tmp.removeLast());
        }
        if (val == tmpStack.getLast()) {
            tmpStack.addLast(val);
        } else if (val > tmpStack.getLast()) {
            do {
                tmp.addLast(tmpStack.removeLast());
            } while (!tmpStack.isEmpty() && tmpStack.getLast() < val);
            tmpStack.addLast(val);
        } else {
            while (!tmp.isEmpty() && tmp.getLast() > val) {
                tmpStack.addLast(tmp.removeLast());
            }
            tmp.addLast(val);
        }
    }

    public void pop() {
        if (peek() != -1) {
            tmpStack.removeLast();
        }
    }

    public int peek() {
        if (tmpStack.isEmpty() && tmp.isEmpty()) {
            return -1;
        }
        while (!tmp.isEmpty()) {
            tmpStack.addLast(tmp.removeLast());
        }
        return tmpStack.getLast();
    }

    public boolean isEmpty() {
        return tmpStack.isEmpty() && tmp.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack2 stack = new SortedStack2();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
