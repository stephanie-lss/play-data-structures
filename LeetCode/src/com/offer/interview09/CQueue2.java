package com.offer.interview09;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/31 13:23
 */
public class CQueue2 {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public CQueue2() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        } else if (!stack2.isEmpty()) {
            return stack2.removeLast();
        } else {
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeLast());
            }
            return stack2.removeLast();
        }
    }
}
