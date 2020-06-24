package com.interview.solution2_5;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 10:45
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        while (l1 != null || l2 != null) {
            int tmp = 0;
            if (l1 != null && l2 != null) {
                tmp = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                tmp = l1.val + carry;
                l1 = l1.next;
            } else {
                tmp = l2.val + carry;
                l2 = l2.next;
            }
            carry = tmp / 10;
            pre.next = new ListNode(tmp % 10);
            pre = pre.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 1, 6};
        int[] nums2 = {5, 9, 3};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}