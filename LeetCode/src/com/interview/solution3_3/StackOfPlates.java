package com.interview.solution3_3;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/6/25 14:51
 */
class StackOfPlates {

    private LinkedList<LinkedList<Integer>> stack;
    private int size = 0;

    public StackOfPlates(int cap) {
        this.stack = new LinkedList<>();
        this.size = cap;
    }

    public void push(int val) {
        if (size <= 0) {
            return;
        }
        if (stack.isEmpty()) {
            stack.addLast(new LinkedList<>());
            stack.getLast().add(val);
        } else {
            if (stack.getLast().size() == size) {
                stack.addLast(new LinkedList<>());
            }
            stack.getLast().add(val);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        LinkedList<Integer> plate = stack.getLast();
        int ret = plate.removeLast();
        if (plate.isEmpty()) {
            stack.removeLast();
        }
        return ret;
    }
/*
["StackOfPlates", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop", "pop"]
[[0], [2], [8], [56], [1], [39], [40], [44], [63], [11], [38], [20], [55], [25], [14], [11], [1], [20], [16], [6], [18], [3], [39], [45], [2], [22], [64], [6], [30], [39], [3], [19], [63], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], []]
 */

    public int popAt(int index) {
        if (stack.size() <= index) {
            return -1;
        }
        LinkedList<Integer> plate = stack.get(index);
        Integer ret = plate.removeLast();
        if (plate.isEmpty()) {
            stack.remove(index);
        }
        return ret;
    }
}