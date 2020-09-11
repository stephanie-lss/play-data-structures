package com.offer.interview06;

import com.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiSheng
 * @date 2020/5/30 14:35
 */
public class Solution3 {
    private List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        dfs(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(ListNode head) {
        if (head == null){
            return;
        }
        dfs(head.next);
        list.add(head.val);
    }
}
