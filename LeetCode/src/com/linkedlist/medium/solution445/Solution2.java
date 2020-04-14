package com.linkedlist.medium.solution445;

import com.ListNode;

import java.util.Stack;

/**
 * @author LiSheng
 * @date 2020/4/14 9:39
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }
        int j = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || j > 0) {
            int i = j;
            i += stack1.isEmpty() ? 0 : stack1.pop();
            i += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode pre = new ListNode(i % 10);
            pre.next = head;
            head = pre;
            j = i / 10;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 4, 4, 3};
        int[] arr2 = {5, 6, 4};
        System.out.println(new Solution2().addTwoNumbers(new ListNode(arr1), new ListNode(arr2)));
    }
}
