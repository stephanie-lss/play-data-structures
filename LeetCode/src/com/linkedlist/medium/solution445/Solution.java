package com.linkedlist.medium.solution445;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/14 9:39
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre1 = reverse(l1);
        ListNode pre2 = reverse(l2);
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        int j = 0;
        while (pre1 != null || pre2 != null || j != 0) {
            int i = j;
            i += pre1 != null ? pre1.val : 0;
            i += pre2 != null ? pre2.val : 0;
            pre.next = new ListNode(i % 10);
            pre = pre.next;
            j = i / 10;
            pre1 = pre1 != null ? pre1.next : null;
            pre2 = pre2 != null ? pre2.next : null;
        }
        return reverse(dummyHead.next);
    }

    private ListNode reverse(ListNode l1) {
        ListNode pre1 = null;
        while (l1 != null) {
            ListNode next = l1.next;
            l1.next = pre1;
            pre1 = l1;
            l1 = next;
        }
        return pre1;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 4, 4, 3};
        int[] arr2 = {5, 6, 4};
        System.out.println(new Solution().addTwoNumbers(new ListNode(arr1), new ListNode(arr2)));
    }
}
