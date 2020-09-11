package com.linkedlist.easy.solution1290;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 11:37
 */
class Solution2 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}
