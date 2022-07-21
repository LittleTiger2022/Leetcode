// 101 ms 24%
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        int res = 0;
        
        for (int i = 0; i< nums.length; i++) {
            dp[i] = 1;
            
            for (int j = 0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            
            res = Math.max(res, dp[i]);
        }
                
        return res;
    }
}
//
