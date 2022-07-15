// s1
// 1ms 39%, 42.6mb, 5%
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) 
            return nums[0];
        return Math.max(rob(nums,0,n-1),rob(nums,1,n));
    }
    int rob(int [] nums, int j, int k) {
        int max=0, preMax=0, noRob, rob;
        for (int i=j;i<k;++i) {
            int cur = nums[i];
            rob = preMax + cur;
            noRob = max;
            max = Math.max(rob,noRob);
            preMax = noRob;
        }
        return max;
    }
}
// s2: the same performance
class Solution {
    public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
     int[] dp = new int[nums.length];
       Arrays.fill(dp, -1);
      int takeFirst = nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length-1), 0, dp);
      Arrays.fill(dp, -1);
      int notTakeFirst = rob(Arrays.copyOfRange(nums, 1, nums.length), 0, dp);
       return Math.max(takeFirst, notTakeFirst);
}
    
private int rob(int[]nums, int i, int[]memo) {
  if(i >= nums.length) return 0;
    if(memo[i] != -1) return memo[i];
      memo[i] = Math.max(nums[i] + rob(nums, i+2, memo), rob(nums, i+1, memo));
   return memo[i];    
    }
}

// solution with good explainations
// O(n) 0ms 100%
// 42 Mb 21%
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)    return nums[0];
        if(nums.length == 2)    return Math.max(nums[0], nums[1]);
        
        // 1st option: including the 1st and excluding the last house
        int resultWithFirst = solve(nums, 0, nums.length - 2);
        // 2nd option: excluding the 1st and including the last house
        int resultWithLast = solve(nums, 1, nums.length - 1);
        
        // Return the maximum of the two results
        return Math.max(resultWithFirst, resultWithLast);
    }
    
    public int solve(int[] nums, int start, int end){        
        if(start == end)    return nums[start];
        
        // Array to store the maximum sum at the current iteration
        // while traversing all houses
        int money[] = new int[nums.length];
        
        /* Base case */
        money[start] = nums[start];
        
        // At the 2nd house, we decide to rob
        // either the 1st house or the 2nd
        // This is the core idea of the transition function
        money[start + 1] = Math.max(nums[start + 1], nums[start]);
        
        for (int i = start + 2; i <= end; ++i)
            /* At ith house we have two options:
             1. not rob it, keeping the money from the (i-1)th house
             2. rob it after the (i-2)th house, skipping the (i-1)th house
              We choose the one that gives the max amount */
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        
        // Return the sum that we have at the last house
        return money[end];
    }
}
