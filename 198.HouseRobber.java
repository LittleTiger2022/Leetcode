// Related Q: 309
// 0ms
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n<1) 
            return 0;
        int rob = nums[0], nRob=0,lastNr = 0;
        for (int i=1;i<n;i++) {
            nRob = Math.max(rob,lastNr);
            rob = lastNr + nums[i];
            lastNr = nRob;
        }
        return Math.max(rob,nRob);
    }
}
