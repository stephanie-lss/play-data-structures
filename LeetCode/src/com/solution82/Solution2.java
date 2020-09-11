package com.solution82;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/7/6 22:10
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = head;
        boolean isDup = false;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                isDup = true;
                cur = cur.next;
            } else {
                if (isDup) {
                    cur = cur.next;
                } else {
                    pre.next = cur;
                    cur = cur.next;
                    pre = pre.next;
                }
                isDup = false;
            }
        }
        if (isDup) {
            pre.next = null;
        } else {
            pre.next = cur;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ListNode head = new ListNode(nums);
        System.out.println(new Solution2().deleteDuplicates(head));
    }
}
