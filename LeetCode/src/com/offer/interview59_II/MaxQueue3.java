package com.offer.interview59_II;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/18 10:02
 */
public class MaxQueue3 {

    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue3() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        } else {
            return deque.peek();
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int ret = queue.poll();
            if (ret == max_value()) {
                deque.removeFirst();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        MaxQueue3 maxQueue3 = new MaxQueue3();
        maxQueue3.push_back(1);
        maxQueue3.push_back(1);
        System.out.println(maxQueue3.pop_front());
        System.out.println(maxQueue3.max_value());
    }
}
