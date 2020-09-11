package com.linkedlist.easy.solution234;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/2/24 9:44
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode cur = slow.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        ListNode h = head;
        ListNode t = pre;

        while (t != null) {
            if (h.val == t.val) {
                h = h.next;
                t = t.next;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,2,1};
        System.out.println(new Solution().isPalindrome(new ListNode(nums)));
    }
}
