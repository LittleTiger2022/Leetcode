// s1
//DP
class Solution {
    int [] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        return combinationSum(nums,target);
    }
    private int combinationSum( int [] nums, int target) {
        if (dp[target] !=-1)
            return dp[target];
        int ans =0;
        for (int num:nums) 
            if (num <=target)
                ans += combinationSum(nums,target-num);
        dp[target] = ans;
        return ans;
    }
}
