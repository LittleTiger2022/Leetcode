// s1: TLE
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Boolean res=false;
        int nLen = nums.length;
        for (int i=0;i<nLen-1;i++) {
            for (int j=i+1;j<Math.min(i+k+1,nLen);j++) {
             //  System.out.println(" i = " + i + " j = " + j + " num[i] = " + nums[i] + " num[j] = " + nums[j]);
                long diff = Math.abs( (long) nums[i] - (long) nums[j]);
              //  System.out.print("diff = " + diff);
                if ( t>=diff)
                {
                    //res=true;
                    //break;
                    return true;
                }
            }
        }
        return res;
            
        }
    }
// to avoid TLE, need to use bucket sort
// 38 ms (83%) 55 Mb 15%
class Solution {
    
    private long getID(long x, long w) {
        return x<0 ? (x+1)/w -1 : x/w;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (t<0)
        return false;
    Map<Long, Long> d = new HashMap<>();
    long w= (long )t +1;
    for (int i=0;i<nums.length;++i) {
        long m = getID(nums[i],w);
        if (d.containsKey(m))
            return true;
        if (d.containsKey(m-1) && Math.abs(nums[i] - d.get(m-1))<w)
            return true;
        if (d.containsKey(m+1) && Math.abs(nums[i] - d.get(m+1))<w)
            return true;
        
        d.put(m, (long) nums[i]);
        if (i>=k)
            d.remove(getID(nums[i-k],w));
    }    
        return false;
    }
}

