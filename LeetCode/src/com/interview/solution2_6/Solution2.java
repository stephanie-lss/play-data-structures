package com.interview.solution2_6;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 11:17
 */
public class Solution2 {
    private boolean res = true;
    private ListNode firstNode;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        firstNode = head;
        back(head);
        return res;
    }

    private void back(ListNode head) {
        if (head == null) {
            return;
        }
        back(head.next);
        if (head.val != firstNode.val) {
            res = false;
            return;
        }
        firstNode = firstNode.next;
    }
}
