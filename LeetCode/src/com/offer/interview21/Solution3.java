package com.offer.interview21;

/**
 * @author LiSheng
 * @date 2020/6/2 11:23
 */
class Solution3 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while ((nums[left] & 1) == 1) {
                left++;
                if (left > right) {
                    return nums;
                }
            }
            while ((nums[right] & 1) == 0) {
                right--;
                if (right < left) {
                    return nums;
                }
            }
            int tmp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6};
        int[] res = new Solution3().exchange(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }
}