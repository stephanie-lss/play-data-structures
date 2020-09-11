package binary;

/**
 * @author LiSheng
 * @date 2020/4/29 19:18
 */
public class BinarySearch2 {
    //普通二分查找，在某个数组中寻找目标值，当不存在目标值时则返回-1
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1; // 注意
            } else if (nums[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        return nums[left] == target ? left : -1;
    }

    //普通二分查找，当目标值一定会存在时可以简化
    int binarySearchTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1; // 注意
            } else {
                right = mid; // 注意
            }
        }
        //left == right
        return nums[left] == target ? left : -1;
    }

    //寻找左侧边界的二分搜索(也就是寻找左边有几个数小于目标值)
    int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (left == nums.length - 1) {
            return -1;
        }
        else if (nums[left + 1] == target) {
            return left + 1;
        } else {
            return -1;
        }
    }

    //寻找右侧边界的二分查找
    int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        //目标值比所有数都要小
        if (left == 0) {
            return -1;
        }
        ////left范围[0,nums.length]
        //为什么返回left - 1，因为当找到了目标值之后一直执行的是left = mid + 1，即往右缩小范围，
        // 当最后退出循环时，left == right，但由于其实条件是左闭右开区间[left,right)，所以其实
        // 此时nums[left]！=target，而是nums[left - 1] == target，所以要返回left-1
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 4};
        int target0 = 8;
        int target1 = 1;
        int target2 = 2;
        int target3 = 3;
        int target4 = 4;
        int target5 = 0;

        System.out.println(new BinarySearch2().left_bound(nums, target0));
        System.out.println(new BinarySearch2().left_bound(nums, target1));
        System.out.println(new BinarySearch2().left_bound(nums, target2));
        System.out.println(new BinarySearch2().left_bound(nums, target3));
        System.out.println(new BinarySearch2().left_bound(nums, target4));
        System.out.println(new BinarySearch2().left_bound(nums, target5));
    }
}
