package com.offer.interview41;

import java.util.PriorityQueue;

/**
 * @author LiSheng
 * @date 2020/6/8 10:43
 */
public class MedianFinder4 {
    private PriorityQueue<Integer> maxPq;
    private PriorityQueue<Integer> minPq;

    /**
     * initialize your data structure here.
     */
    public MedianFinder4() {
        this.minPq = new PriorityQueue<>();
        this.maxPq = new PriorityQueue<>((p, q) -> (q - p));
    }

    public void addNum(int num) {
        if (minPq.size() == maxPq.size()) {
            minPq.offer(num);
            maxPq.offer(minPq.poll());
        } else {
            maxPq.offer(num);
            minPq.offer(maxPq.poll());
        }
    }

    public double findMedian() {
        if (((maxPq.size() + minPq.size()) & 1) == 1) {
            return maxPq.peek();
        } else {
            return (maxPq.peek() + minPq.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder4 medianFinder3 = new MedianFinder4();
        medianFinder3.addNum(1);
        medianFinder3.addNum(2);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(3);
        System.out.println(medianFinder3.findMedian());
    }
}
