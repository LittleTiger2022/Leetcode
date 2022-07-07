// s1. My naive solution
// 8ms 65%, 42Mb (32%)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        
            
        List<String> res= new ArrayList<String>();
        if (nums.length==0)
            return res;
        if(nums.length==1) {
            res.add(Integer.toString(nums[0]));
            return res;
        }
        
         int start = nums[0];
         int end = nums[0];
        int i=1;
        while(i<nums.length) {
            while(i<nums.length &&nums[i]==nums[i-1]+1) {
                end = nums[i];
                i++;
            }
            if (start==end) {
                res.add(Integer.toString(start));
                }
            else if (start<end) {
               String temp = Integer.toString(start)+"->" + Integer.toString(end);
                res.add(temp);
               
            }
            if (i<nums.length) {
             start = nums[i];
              end  = nums[i];
            }
          // System.out.println(" i= " + i + " start = "+ start + " end = "+ end  + " nums.length =" + nums.length);
            if((i==nums.length-1) && (start==end)) {
        //  System.out.println(" i= " + i + " start = "+ start + " end = "+ end );
                res.add(Integer.toString(start));
            }
        i++;
        }
        return res;
    
        
    }
}

// more elegent solution
// the same or a little long speed, but very concise
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        int first, last;
        for (int i=0;i< nums.length;++i) {
            first = last = nums[i];
            while (i<nums.length-1 && last +1 == nums[i+1]) {
                last = nums[++i];
            }
            if (last==first)
                ans.add(String.valueOf(last));
            else
                ans.add(first+"->"+last);
        }
        return ans;
    }
}

