package com.offer.interview31;

import java.util.LinkedList;

/**
 * @author LiSheng
 * @date 2020/5/16 18:06
 */
public class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int p = 0;
        for (int push : pushed) {
            stack.addLast(push);
            while (p < popped.length && !stack.isEmpty() && stack.getLast() == popped[p]) {
                stack.removeLast();
                p++;
            }
        }
        return p == popped.length;
    }
}
