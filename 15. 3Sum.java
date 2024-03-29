// use HashMap O(n**2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> ts = new HashSet();
    HashMap <Integer,Integer> map = new HashMap();
    Arrays.sort(nums);
    for (int i=0;i<nums.length;i++) {
        map.put(nums[i],i);
    }
        for (int i=0; i<nums.length;i++) {
         int f = nums[i];
         for (int j=i+1; j<nums.length;j++) {
             List<Integer> l = new ArrayList();
             int s = nums[j];
             int t = 0 - f - s;
             if (map.containsKey( t) && map.get(t)>j) {
                 l.add(f);
                 l.add(s);
                 l.add(t);
                 ts.add(l);
             }
         }   
        }
        return new ArrayList(ts);
    }
}
// 35 ms O(nlogn)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length,sum=0;
        for (int    i = 0; i<n-2;){
            if(nums[i]>0) break;
            int j = i+1, k = n-1;
            while(j<k) {
                sum = nums[i]+nums[j]+nums[k];
                if (sum==0) ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                if (sum<=0)
                  while(nums[j]==nums[++j] && k>j);
                if (sum>=0)
                     while(nums[k]== nums[--k] && k >j);
                
            }
          while(nums[i]==nums[++i] && i<n-2);
        }
        return ans;
        
    }
}


// 650 ms. The same method as above O(n**2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }
}
// 74 ms O(nlogn). Update the above code with 夹逼法

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        int sum=0;
        for(int i=0; i<nums.length-2;i++){
            if (nums[i]>0) break;
            int j =i+1, k = nums.length-1;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                if(sum==0) res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                 if ( sum <=0)
                while(nums[j]==nums[++j] && k>j);
                if (sum>=0) 
                while(nums[k]== nums[--k] && k >j);
            }
        }
        return new ArrayList<>(res);

    }
}
