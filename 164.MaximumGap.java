// my naive solution
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length<2)
            return 0;
        Arrays.sort(nums);
        int maxGap =0;
        for (int i=1;i<nums.length;i++) {
            maxGap = Math.max(maxGap,nums[i]-nums[i-1]);
        }
        return maxGap;
    }
}

// proper solution with bucket sort method
class Solution {
    public int maximumGap(int[] nums) {
        if (nums==null || nums.length<2)
            return 0;
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
      //   System.out.println(" min = " + min + " max = " + max);
        int gap = (int) Math.ceil((double ) (max- min)/ (nums.length-1));
        int [] minBuckets = new int[nums.length-1];
        int [] maxBuckets = new int[nums.length-1];
        
        Arrays.fill(minBuckets,Integer.MAX_VALUE);
        Arrays.fill(maxBuckets,Integer.MIN_VALUE);
        
        for (int num: nums) {
            if (num==max || num == min)
                continue;
            int i = (num - min)/gap;
            minBuckets[i] = Math.min(minBuckets[i],num);
            maxBuckets[i] = Math.max(maxBuckets[i],num);
        }
   //     System.out.println(" Size = " + minBuckets.length);
        
        int ans = Integer.MIN_VALUE, prev= min;
        for (int i=0;i<minBuckets.length;i++) {
        //    System.out.println(" minBucket = " + minBuckets[i] + " maxBucket = " + maxBuckets[i]);
            if (minBuckets[i]==Integer.MAX_VALUE || maxBuckets[i]==Integer.MIN_VALUE)
                continue;
            ans = Math.max(minBuckets[i] - prev, ans);
            prev = maxBuckets[i];
        //    System.out.println(" ans = "+ ans + "  prev = " + prev);
        }
        ans = Math.max(ans,max-prev);
        return ans;
    }
}

