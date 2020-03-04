package com.solution82;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/22 21:31
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (pre.next != null) {
            int v1 = pre.next.val;
            if (pre.next.next == null) {
                break;
            }
            if (v1 == pre.next.next.val) {
                while (pre.next != null && pre.next.val == v1) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5};
        System.out.println(new Solution().deleteDuplicates(new ListNode(nums)));
    }
}
