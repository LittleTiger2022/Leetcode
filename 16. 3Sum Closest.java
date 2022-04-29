// 8 ms
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, j=0, k =0, sum=0,closeValue=Integer.MAX_VALUE,ans=0;       
        Arrays.sort(nums);
        
        for (int i=0; i<n-2;++i) {
            j = i+1;
            k = n-1;
            while(j<k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum==target) return sum;
                if (Math.abs(sum-target)<closeValue) {
                    closeValue = Math.abs(sum-target);
                    ans=sum;
                }
                if (sum<target) 
                    while(nums[j]==nums[++j] && j<k);
                if (sum>target)
                    while(nums[k]==nums[--k] && j<k);
                }
            }
        // System.out.println(nums[0]);
        return ans;
    }
}
