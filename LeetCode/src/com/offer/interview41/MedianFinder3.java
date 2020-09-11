package com.offer.interview41;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/6/8 10:43
 */
public class MedianFinder3 {
    private PriorityQueue<Integer> maxPq;
    private PriorityQueue<Integer> minPq;

    /**
     * initialize your data structure here.
     */
    public MedianFinder3() {
        this.maxPq = new PriorityQueue<>();
        this.minPq = new PriorityQueue<>((p, q) -> (q - p));
    }

    public void addNum(int num) {
        if (maxPq.size() == minPq.size()) {
            maxPq.offer(num);
            minPq.offer(maxPq.poll());
        } else if (maxPq.size() < minPq.size()) {
            minPq.offer(num);
            maxPq.offer(minPq.poll());
        }
    }

    public double findMedian() {
        return maxPq.size() == minPq.size() ? (maxPq.peek() + minPq.peek()) / 2.0 : minPq.peek();
    }

    public static void main(String[] args) {
        MedianFinder3 medianFinder3 = new MedianFinder3();
        medianFinder3.addNum(1);
        medianFinder3.addNum(2);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(3);
        System.out.println(medianFinder3.findMedian());
    }
}
