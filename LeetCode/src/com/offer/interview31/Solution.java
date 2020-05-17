package com.offer.interview31;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/16 17:19
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pu = pushed.length, po = popped.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int p = 0, last = 0;
        for (int i = 0; i < po && p < pu; i++) {
            if (!stack.isEmpty() && stack.getLast() == popped[i]) {
                stack.removeLast();
                continue;
            }
            for (int j = p; j < pu; j++) {
                if (pushed[j] != popped[i]) {
                    stack.addLast(pushed[j]);
                } else {
                    p = j + 1;
                    last = i + 1;
                    break;
                }
            }
        }
        if (po - last != stack.size()) {
            return false;
        }
        for (int i = last; i < po; i++) {
            if (popped[i] != stack.removeLast()) {
                return false;
            }
        }
        return true;
    }
}