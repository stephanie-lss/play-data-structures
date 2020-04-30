package com.solution153;

/**
 * @author LiSheng
 * @date 2020/4/29 14:54
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[left]) {
                //mid右边有序，此时的最小值应该在mid左边或者就是mid本身
                if (nums[mid] < nums[mid - 1]) {
                    //此时nums[mid]就为最小值，因为这时候的nums[mid]为右边有序数组的第一个值
                    return nums[mid];
                } else {
                    //这个时候就需要继续往左边找，并且由于右边是开区间，所以right=mid，
                    // 因为nums[mid]已经被排除了最小值的可能
                    right = mid;
                }
                //这里隐含了一个nums[mid] == nums[left]的情况
            } else {
                //此时可能会出现两种情况，[0,1,2,3,4,5,6,7]或[4,5,6,7,8,9,0,1,2]
                //即最小值既可能在左边，也可能在右边，因此还需要继续判断,不过需要清楚
                //的知道mid左边的数字一定是有序的
                //在第一个if中处理=号出现的情况
                if (nums[mid] <= nums[right - 1]) {
                    //<:此时最小值在左边，并且由于左边有序，因此可以直接确定最小值
                    //=:因为数组不存在重复元素因此当=成立时，left = mid = right-1 ——>[4,5,6,7,8,9,0]
                    //此时其实left和mid都是指向0这个元素的索引，因此就是最小值
                    return nums[left];
                } else {
                    //此时最小值在右边
                    left = mid + 1;
                }
            }
        }
        throw null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(new Solution().findMin(nums));
    }
}
