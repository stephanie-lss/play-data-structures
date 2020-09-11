package com.offer.interview31;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/7/8 20:22
 */
public class Solution4 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int idx = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (!stack.isEmpty()) {
                int num = stack.getLast();
                if (num != popped[idx]) {
                    stack.addLast(pushed[i]);
                } else {
                    stack.removeLast();
                    idx++;
                }
            } else {
                stack.addLast(pushed[i]);
            }
        }
        return stack.isEmpty();
    }
}
