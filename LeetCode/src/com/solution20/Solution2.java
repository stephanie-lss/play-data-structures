package com.solution20;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiSheng
 * @date 2020/8/14 8:54
 */
public class Solution2 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.tryLock();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character p = stack.pop();
                if (c == '}' && p == '{') {
                    continue;
                }
                if (c == ']' && p == '[') {
                    continue;
                }
                if (c == ')' && p == '(') {
                    continue;
                }
                return false;
            }
        }

        return stack.isEmpty();
    }
}
