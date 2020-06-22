package com.offer.interview59_II;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author LiSheng
 * @date 2020/5/19 18:50
 */
class MaxQueue {

    private Queue<Integer> queue;
    private PriorityQueue<Integer> pq;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }

    public int max_value() {
        if (pq.isEmpty()) {
            return -1;
        }
        return pq.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        pq.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer ret = queue.poll();
        pq.remove(ret);
        return ret;
    }
}