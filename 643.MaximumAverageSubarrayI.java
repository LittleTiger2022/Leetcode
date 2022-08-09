// s1
// O(n) 8 ms (44%) 108 Mb* 27%)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.0;
        if (nums.length<=k) {
            for (int i=0;i<nums.length;i++)
                res += nums[i];
        
        res = res/nums.length;
        
        }
        else {
            double temp_res =0.0;
        for (int i=0;i<k;i++)
            temp_res += nums[i];
            res = temp_res;
            for (int i=k;i<nums.length;i++) {
                temp_res = temp_res-nums[i-k]+ nums[i];
                // System.out.println("res = " + res);
                res = Math.max(res, temp_res);
            }
            res = res/k;
            }
        return res;
    }
}
