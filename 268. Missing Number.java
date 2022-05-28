// my naive solution
// 9ms
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        if (nums[right]==right) 
            return right+1;
        if (nums[left]>0)
            return 0;
        
        while(left<=right) {
            int mid = (left+right)/2;
            if (mid==nums[mid])
                left = mid+1;
            if (mid<nums[mid])
                right= mid-1;
        }
        return left;
    }
}
// cleaned version 
// 6ms
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        
        while(left<=right) {
            int mid = (left+right)/2;
            if (mid==nums[mid])
                left = mid+1;
            if (mid<nums[mid])
                right= mid-1;
        }
        return left;
    }
}
