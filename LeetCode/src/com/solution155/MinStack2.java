package com.solution155;

/**
 * @author LiSheng
 * @date 2020/5/12 14:00
 */
class MinStack2 {

    private class Node {
        private int val;
        private int min;
        private Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node dummyHead;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        dummyHead = new Node(-1, 100);
    }

    public void push(int x) {
        if (dummyHead.next == null) {
            Node node = new Node(x, x);
            node.next = null;
            dummyHead.next = node;
        } else {
            Node node = new Node(x, Math.min(x, dummyHead.next.min));
            node.next = dummyHead.next;
            dummyHead.next = node;
        }
    }

    public void pop() {
        dummyHead.next = dummyHead.next.next;
    }

    public int top() {
        return dummyHead.next.val;
    }

    public int getMin() {
        return dummyHead.next.min;
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.top();
        minStack.pop();
        minStack.getMin();
    }
}
