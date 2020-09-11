package com.top100.solution139;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/5 21:16
 */
class Solution4 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[s.length()];
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            if (!visited[index]) {
                for (int i = index + 1; i <= s.length(); i++) {
                    if (wordDict.contains(s.substring(index, i))) {
                        queue.offer(i);
                        if (i == s.length()) {
                            return true;
                        }
                    }
                }
                visited[index] = true;
            }
        }
        return false;
    }
}
