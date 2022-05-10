// 4 ms
class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length,maxJump=0;
        for (int i =0;i<n;i++) {
            if (i>maxJump)
                return false;
            maxJump = Math.max(nums[i]+i,maxJump);
           
        }
        return true;
    }
}
