//s1
// 14 ms (7.5%) 84Mb (84%)
class Solution {
    public int maxRotateFunction(int[] nums) {
      // corner case
        if (nums.length==0)
            return 0;
        int sum=0, iteration =0, len = nums.length;
        for (int i=0;i<len;i++) {
            sum += nums[i];
            iteration+=(nums[i]*i);
        }
        int max = iteration;
        for (int j=1;j<len;j++) {
            iteration = iteration - sum + nums[j-1]*len;
            max = Math.max(max,iteration);
        }
        return max;
    }
}
