package com.offer.interview06;

import com.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/7/3 9:56
 */
class Solution4 {
    private List<Integer> list;

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        this.list = new ArrayList<>();
        dfs(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(ListNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.next);
        list.add(cur.val);
    }
}