package com.top100.solution2;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/5/7 21:41
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = null;
        ListNode head = dummyHead;
        boolean carry = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
            if (carry) {
                sum += head.val;
                if (sum < 10) {
                    carry = false;
                    head.val = sum;
                } else {
                    carry = true;
                    head.val = sum % 10;
                    head.next = new ListNode(sum / 10);
                    head = head.next;
                }
            } else {
                if (sum < 10) {
                    carry = false;
                    head.next = new ListNode(sum);
                    head = head.next;
                } else {
                    carry = true;
                    head.next = new ListNode(sum % 10);
                    head = head.next;
                    head.next = new ListNode(sum / 10);
                    head = head.next;
                }
            }
        }
        if (l1 != null) {
            remainder(l1, head, carry);
        } else {
            remainder(l2, head, carry);
        }
        return dummyHead.next;
    }

    private void remainder(ListNode l1, ListNode head, boolean carry) {
        while (l1 != null) {
            if (carry) {
                int sum = head.val + l1.val;
                if (sum < 10) {
                    head.val = head.val + l1.val;
                    head.next = l1.next;
                    break;
                } else {
                    head.val = sum % 10;
                    head.next = new ListNode(sum / 10);
                    head = head.next;
                }
            } else {
                head.next = l1;
                break;
            }
            l1 = l1.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 1, 6};
        int[] arr2 = {0};
        ListNode l1 = new ListNode(arr);
        ListNode l2 = new ListNode(arr2);
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }
}