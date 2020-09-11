package com.top100.solution142;

import com.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/2 15:11
 * 初始版
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        if (cur == null) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        int pos = -1;
        while (cur != null) {
            if (!list.contains(cur)) {
                list.add(cur);
            } else {
                pos = list.indexOf(cur);
                break;
            }
            cur = cur.next;
        }
        if (pos == -1) {
            return null;
        }
        while (pos != 0) {
            head = head.next;
            pos--;
        }
        return head;
    }
}