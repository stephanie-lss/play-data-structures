package com.offer.interview59_II;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/6/18 10:02
 */
public class MaxQueue2 {

    Queue<Integer> queue;
    PriorityQueue<Integer> pq;

    public MaxQueue2() {
        queue = new LinkedList<>();
        pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }

    public int max_value() {
        if (pq.isEmpty()) {
            return -1;
        } else {
            return pq.peek();
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        pq.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        } else {
            int ret = queue.poll();
            pq.remove(ret);
            return ret;
        }
    }
}
