package com.solution365;

import java.util.*;

/**
 * @author LiSheng
 * @date 2020/3/21 11:10
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }

        Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
        queue.add(start);
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            Integer currentX = entry.getKey();
            Integer currentY = entry.getValue();
            if (currentX == z || currentY == z || currentX + currentY == z) {
                return true;
            }
//            if (currentX == 0) {
                //如果容器x为空，把它倒满
                addQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, currentY));
//            }
//            if (currentY == 0) {
                //如果容器y为空，把它倒满
                addQueue(queue, visited, new AbstractMap.SimpleEntry<>(currentX, y));
//            }
//            if (currentY < y) {
                //如果容器y不为满，把桶x倒空
                addQueue(queue, visited, new AbstractMap.SimpleEntry<>(0, currentY));
//            }
//            if (currentX < x) {
                //如果容器x不为满，把桶y倒空
                addQueue(queue, visited, new AbstractMap.SimpleEntry<>(currentX, 0));
//            }
            int moveSize = Math.min(currentX, y - currentY);
            addQueue(queue, visited, new AbstractMap.SimpleEntry<>(currentX - moveSize, currentY + moveSize));
            moveSize = Math.max(x - currentX, currentY);
            addQueue(queue, visited, new AbstractMap.SimpleEntry<>(currentX + moveSize, currentY - moveSize));
        }
        return false;
    }
    private void addQueue(Queue<Map.Entry<Integer, Integer>> queue, Set<Map.Entry<Integer, Integer>> visited, AbstractMap.SimpleEntry<Integer, Integer> newEntry) {
        if (!visited.contains(newEntry)) {
            visited.add(newEntry);
            queue.add(newEntry);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(3,5,4));
    }
}
