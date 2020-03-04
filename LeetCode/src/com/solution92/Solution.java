package com.solution92;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/20 11:38
 * 为解决
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (n==1){
            return head;
        }
        int t = m - 2;
        ListNode cHead = head;
        while (t != 0) {
            cHead = cHead.next;
            t--;
        }
        ListNode cTail = head;
        while (n != 0 && cTail!= null) {
            cTail = cTail.next;
            n--;
        }

        ListNode cur = cHead;
        while (cur.next != cTail) {
            cur = cur.next;
        }
        cur.next = null;
        reverseList(cHead.next);
        cHead.next = cur;
        while (cHead.next != null) {
            cHead = cHead.next;
        }
        cHead.next = cTail;
        return head;
    }


    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] nums = {3,5};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution().reverseBetween(head,1,2));
    }
}