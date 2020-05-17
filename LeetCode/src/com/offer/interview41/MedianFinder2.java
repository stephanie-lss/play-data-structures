package com.offer.interview41;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/5/17 16:10
 */
class MedianFinder2 {

    PriorityQueue<Integer> smallPQ;
    PriorityQueue<Integer> bigPQ;

    /**
     * initialize your data structure here.
     */
    public MedianFinder2() {
        smallPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        bigPQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smallPQ.size() == bigPQ.size()) {
            bigPQ.add(num);
            smallPQ.add(bigPQ.poll());
        } else {
            smallPQ.add(num);
            bigPQ.add(smallPQ.poll());
        }
    }

    public double findMedian() {
        if (smallPQ.size() == bigPQ.size()) {
            return (smallPQ.peek() + bigPQ.peek()) / 2.0;
        } else {
            return smallPQ.peek();
        }
    }
}