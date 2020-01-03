package com.solution155;

import java.util.ArrayList;
import java.util.Collections;

class MinStack {

    private class Node {
        int e;
        Node next;

        public Node(int e) {
            this.e = e;
        }
    }

    public Node dummyHead;
    public int size;
    public ArrayList<Integer> arrayList = new ArrayList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dummyHead = new Node(-1);
        size = 0;
    }

    public void push(int x) {
        arrayList.add(x);
        Node cur = dummyHead;
        Node newNode = new Node(x);
        newNode.next = cur.next;
        cur.next = newNode;
        size++;
    }

    public void pop() {
        if (size != 0) {
            arrayList.remove(arrayList.size() - 1);
            dummyHead.next = dummyHead.next.next;
        }
    }

    public int top() {
        return dummyHead.next.e;
    }

    public int getMin() {
        if (size != 0) {
            return Collections.min(arrayList);
        }
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */