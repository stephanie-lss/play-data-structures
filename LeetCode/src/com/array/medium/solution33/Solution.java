package com.array.medium.solution33;

/**
 * @author LiSheng
 * @date 2020/4/27 9:12
 */
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        int left = 0;
        int right = n - 1;

        int oriEnd = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[0]) {
                if (mid == n - 1) {
                    oriEnd = n - 1;
                    break;
                }
                //原数组末端在mid的右边
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    oriEnd = mid;
                    break;
                } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    oriEnd = mid - 1;
                    break;
                } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[0]) {
                //原数组末端在mid的左边
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    oriEnd = mid;
                    break;
                } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    oriEnd = mid - 1;
                    break;
                } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    right = mid - 1;
                }
            } else {
                oriEnd = mid;
                break;
            }
        }
        //找到了原数组的末端oriEnd
        if (target == nums[oriEnd]) {
            return oriEnd;
        } else if (target < nums[oriEnd] && target >= nums[0]) {
            return binarySearch(nums, target, 0, oriEnd - 1);
        } else if (oriEnd + 1 < n && target >= nums[oriEnd + 1] && target <= nums[n - 1]) {
            return binarySearch(nums, target, oriEnd + 1, n - 1);
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, right);
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, left, mid - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}