package com.solution1095;

/**
 * @author LiSheng
 * @date 2020/6/1 10:24
 */
public class Solution2 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mountainPeek = findMountainPeek(mountainArr, 0, mountainArr.length() - 1);
        int left = binarySearchLeft(target, mountainArr, 0, mountainPeek);
        int right = binarySearchRight(target, mountainArr, mountainPeek + 1, mountainArr.length() - 1);
        return left != -1 ? left : right;
    }

    private int binarySearchRight(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchLeft(int target, MountainArray mountainArr, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findMountainPeek(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 < mountainArr.length() && mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
