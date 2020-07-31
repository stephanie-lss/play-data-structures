package com;

import java.util.Stack;

public class 链表反转 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode tmp = new ListNode(nums);
        System.out.println("反转前:" + tmp);
        int[] ints = reversePrint(tmp);
        tmp = new ListNode(ints);
        System.out.println("反转后:" + tmp);
    }

    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }

        return print;
    }
}