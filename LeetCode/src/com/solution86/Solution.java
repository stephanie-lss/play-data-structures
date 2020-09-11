package com.solution86;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/22 20:04
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode pre1 = dummyHead1;
        ListNode pre2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                pre1.next = head;
                head = head.next;
                pre1 = pre1.next;
                pre1.next = null;
            } else {
                pre2.next = head;
                head = head.next;
                pre2 = pre2.next;
                pre2.next = null;
            }
        }
        pre1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        System.out.println(new Solution().partition(new ListNode(nums), 3));
    }

}
