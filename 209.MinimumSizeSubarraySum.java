//s1
// 1ms O(n) 100%; 58Mb, 8%
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, i=0,j=0,sum=0;
        while (j<nums.length) {
            sum +=nums[j++];
            while (sum>=target) {
                ans = Math.min(ans,j-i);
                sum-=nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0: ans;
    }
}
