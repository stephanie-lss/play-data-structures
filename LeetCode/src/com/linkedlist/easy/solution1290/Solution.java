package com.linkedlist.easy.solution1290;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/4/6 11:37
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int res = 0;
        cur = head;
        while (n != -1) {
            res += Math.pow(2, n - 1) * cur.val;
            cur = cur.next;
            n--;
        }
        return res;
    }
}
