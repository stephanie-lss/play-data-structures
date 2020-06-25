package com.interview.solution3_1;

/**
 * @author LiSheng
 * @date 2020/6/25 14:02
 */
public class TripleInOne2 {

    private int[] stack;
    private int[] p;
    private int size = 0;

    public TripleInOne2(int stackSize) {
        this.p = new int[3];
        p[1] = stackSize;
        p[2] = stackSize * 2;
        this.size = stackSize;
        this.stack = new int[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        if (p[stackNum] < (stackNum + 1) * size) {
            stack[p[stackNum]] = value;
            p[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        if (p[stackNum] > stackNum * size) {
            p[stackNum]--;
            return stack[p[stackNum]];
        } else {
            return -1;
        }
    }

    public int peek(int stackNum) {
        if (p[stackNum] > stackNum * size) {
            return stack[p[stackNum] - 1];
        } else {
            return -1;
        }
    }

    public boolean isEmpty(int stackNum) {
        return p[stackNum] == stackNum * size;
    }
}
