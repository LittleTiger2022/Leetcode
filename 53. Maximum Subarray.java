// 2ms
// write code is simple once you know the Kadane's Algorithm
// local_maximum at index i is the maximum of A[i] and the sum of A[i] and local_maximum at index i-1.
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n<2) {return nums[0];}
        
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        
        for (int i=0; i<n;i++) {
        localMax = Math.max(nums[i],localMax+nums[i]);    
        if (localMax > globalMax ) globalMax = localMax;
        }
         
            return globalMax;
        
    }
}
