package com.solution92;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/20 11:38
 * 为解决
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode pre = dummyhead;
        ListNode cur = head;
        int len = 1;
        while (len != m) {
            pre = cur;
            cur = cur.next;
            len++;
        }
        ListNode start = cur;
        ListNode newPre = null;
        while (true) {
            ListNode next = cur.next;
            cur.next = newPre;
            if (len == n) {
                pre.next = cur;
                start.next = next;
                return dummyhead.next;
            }
            newPre = cur;
            cur = next;
            len++;
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution().reverseBetween(head, 1, 2));
    }
}