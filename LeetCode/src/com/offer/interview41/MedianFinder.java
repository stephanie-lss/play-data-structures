package com.offer.interview41;

import java.util.ArrayList;

/**
 * @author LiSheng
 * @date 2020/5/17 15:07
 */
class MedianFinder {

    ArrayList<Integer> list;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            //binarySearch
            binarySearchAndAdd(list, 0, list.size() - 1, num);
        }
    }

    private void binarySearchAndAdd(ArrayList<Integer> list, int left, int right, int num) {
        if (left > right) {
            if (right < 0) {
                list.add(0, num);
            } else {
                list.add(list.size(), num);
            }
            return;
        }
        int mid = left + (right - left) / 2;
        if (list.get(mid) == num) {
            list.add(mid, num);
        } else if (list.get(mid) < num) {
            if (mid + 1 < list.size() && list.get(mid + 1) >= num) {
                list.add(mid + 1, num);
            } else {
                binarySearchAndAdd(list, mid + 1, right, num);
            }
        } else if (list.get(mid) > num) {
            if (mid - 1 >= 0 && list.get(mid - 1) <= num) {
                list.add(mid, num);
            } else {
                binarySearchAndAdd(list, left, mid - 1, num);
            }
        }
    }

    public double findMedian() {
        int size = list.size();
        if (size == 0) {
            return 0.0;
        }
        if ((size & 1) == 1) {
            return list.get(size / 2);
        } else {
            return (list.get(size / 2) + list.get((size - 1) / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder med = new MedianFinder();
        med.addNum(6);
        System.out.println(med.findMedian());
        med.addNum(10);
        System.out.println(med.findMedian());
        med.addNum(2);
        System.out.println(med.findMedian());
        med.addNum(6);
        System.out.println(med.findMedian());
        med.addNum(5);
        System.out.println(med.findMedian());
        med.addNum(0);
        System.out.println(med.findMedian());
    }
}



