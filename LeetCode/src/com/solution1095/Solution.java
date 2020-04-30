package com.solution1095;

/**
 * @author LiSheng
 * @date 2020/4/29 9:01
 */

interface MountainArray {
    public int get(int index);

    public int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        //找到i
        int i = binarySearchTop(mountainArr, 0, n);
        //二分查找
        int res1 = binarySearch1(mountainArr, 0, i + 1, target);
        int res2 = binarySearch2(mountainArr, i + 1, n, target);
        return res1 == -1 ? res2 : res1;
    }

    private int binarySearchTop(MountainArray mountainArr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < mountainArr.length() && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                return binarySearchTop(mountainArr, mid + 1, right);
            } else {
                return binarySearchTop(mountainArr, left, mid);
            }
        }
        return left;
    }

    private int binarySearch1(MountainArray mountainArr, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                return binarySearch1(mountainArr, left, mid, target);
            } else {
                return binarySearch1(mountainArr, mid + 1, right, target);
            }
        }
        return -1;
    }

    private int binarySearch2(MountainArray mountainArr, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                return binarySearch2(mountainArr, mid + 1, right, target);
            } else {
                return binarySearch2(mountainArr, left, mid, target);
            }
        }
        return -1;
    }
}
