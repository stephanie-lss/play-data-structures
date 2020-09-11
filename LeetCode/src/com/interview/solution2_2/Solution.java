package com.interview.solution2_2;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 10:10
 */
class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        while (true) {
            ListNode tmp = cur;
            for (int i = 0; i < k; i++) {
                tmp = tmp.next;
            }
            if (tmp == null) {
                return cur.val;
            } else {
                cur = cur.next;
            }
        }
    }
}