package com.interview.solution3_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/6/25 13:34
 */
class TripleInOne {

    private List<LinkedList<Integer>> stack;
    private int size;

    public TripleInOne(int stackSize) {
        this.stack = new ArrayList<>();
        this.size = stackSize;
        for (int i = 0; i < 3; i++) {
            stack.add(new LinkedList<>());
        }
    }

    public void push(int stackNum, int value) {
        LinkedList<Integer> list = stack.get(stackNum);
        if (list.size() != size) {
            list.addLast(value);
        }
    }

    public int pop(int stackNum) {
        LinkedList<Integer> list = stack.get(stackNum);
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.removeLast();
        }
    }

    public int peek(int stackNum) {
        LinkedList<Integer> list = stack.get(stackNum);
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.getLast();
        }
    }

    public boolean isEmpty(int stackNum) {
        return stack.get(stackNum).isEmpty();
    }
}
