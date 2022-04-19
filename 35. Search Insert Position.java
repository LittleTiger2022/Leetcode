// 0ms

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0, mid=0, right= nums.length-1;
        if (nums[left]> target) return 0;
        if (nums[right]< target) return right+1;
        
        while (left<=right){
            mid = left + (right-left)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]> target) right = mid-1;
            else left = mid+1;
        }
        return (nums[mid]> target)?right+1:left;
    }
}

// another briefer version
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0) return 0;
        int left=0, mid=0, right= nums.length-1;

        while (left<=right){
            mid = left + (right-left)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]> target) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}
