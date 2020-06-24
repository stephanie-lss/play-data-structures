package com.interview.solution2_3;

import com.ListNode;

/**
 * @author LiSheng
 * @date 2020/6/24 10:14
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}