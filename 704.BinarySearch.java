// my grind75 solution
// 0ms 100% 54Mb 26%
class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        int res= -1;
        while (left<=right) {
            int mid = (left+right)/2;
            if (nums[mid]==target) {
                res = mid;
                break;
            }
            else if (nums[mid]<target)
                left = mid+1;
            else
                right=mid-1;
                
        }
        return res;
    }
}
