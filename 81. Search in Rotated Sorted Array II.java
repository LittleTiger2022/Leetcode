// soltuion from "Q400"
class Solution {
    public boolean search(int[] nums, int target) {
        int start =0, end = nums.length-1, mid=-1;
        while (start<=end) {
            mid = (start + end)/2;
            if (nums[mid]==target)
                return true;
            // mid less than end or mid less than start
            if (nums[mid]<nums[end] || nums[mid]<nums[start])
                // target > mid and <= end
                if (target>nums[mid] && target <=nums[end])
                    start = mid +1;
                else 
                    end = mid-1;
            // mid large than start or mid large than end
            else if (nums[mid]> nums[start] || nums[mid]>nums[end])
                // target less than mid AND >=start
                if (target < nums[mid] && target >= nums[start])
                    end = mid -1;
                else
                    start = mid+1;
            else
                end--;
        }
        return false;
    }
}

// solution from offical Leetcode
class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return false;
        int end = n - 1;
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (!isBinarySearchHelpful(nums, start, nums[mid])) {
                start++;
                continue;
            }
            // which array does pivot belong to.
            boolean pivotArray = existsInFirst(nums, start, nums[mid]);

            // which array does target belong to.
            boolean targetArray = existsInFirst(nums, start, target);
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays, recall that xor is true when both operands are distinct
                if (pivotArray) {
                    start = mid + 1; // pivot in the first, target in the second
                } else {
                    end = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    // returns true if we can reduce the search space in current binary search space
    private boolean isBinarySearchHelpful(int[] arr, int start, int element) {
        return arr[start] != element;
    }

    // returns true if element exists in first array, false if it exists in second
    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }
}
