// my naive solution
// 9 ms (38%), 51Mb (8%)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
         List<Integer> res =new ArrayList<Integer>();
        int nLen = nums.length;
        if (nLen<3) {
            for (int i=0;i<nLen;i++)
                if (i>0 && nums[i]!=nums[i-1])
            res.add(nums[i]);
                else if (i==0)
                    res.add(nums[i]);
            else
                 return res;             
            return res;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int [] temp =new int [nLen];
        int uniqueData = 0;
        for (int i=0;i<nLen;i++) {
                Integer    count = map.get(nums[i]);
                map.put(nums[i],(count==null)?1:count+1);
                if (count==null)
                temp[uniqueData++] = nums[i];
            } 
        
        //
       
        int finalCount =0;
        int thresthold = nLen/3;
        for (int i=0;i<map.size();i++) {
            int count = map.get(temp[i]);
            if (count>thresthold)
                res.add(temp[i]);
        }
        return res;
        
    }
}
// solution 2: only Two values are needed
// 8 ms 40% 46Mb  (91%)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
         List<Integer> res =new ArrayList<Integer>();
        int nLen = nums.length;
        
        if (nLen==1 || (nLen==2 & nums[0] == nums[1])) {
            res.add(nums[0]);
            return res;
        }
        
        if (nLen==2) {
            for (int i=0;i<nLen;i++)
            res.add(nums[i]);           
            return res;
        }


        HashMap<Integer,Integer> map = new HashMap<>();
               int thresthold = nLen/3;
               int onlyTwo=0;
        for (int i=0;i<nLen;i++) {
                Integer    count = map.get(nums[i]);
                Integer value = (count==null)?1:count+1;
                map.put(nums[i],value);
    //    System.out.println("count = " + value   +"  th = " + thresthold);
                if (value >   thresthold) {
       //         System.out.println(" res size = " + res.size());
                        
                    if (res.size()==0) {
                        res.add(nums[i]);
                        onlyTwo++;
     //                 System.out.println("res exist = " + res.get(0) + " new add " + nums[i]);
                    }
  //         
                   else if     ( res.size()>0&& res.get(0)!=nums[i]) {
                    res.add(nums[i]);
                   onlyTwo++; 
   //            System.out.println("res exist = " + res.get(0) + " new add " + nums[i] + "   onlyTwo = " + onlyTwo);
                      
                   }
                }
             if (onlyTwo==2) break;
            } 
        
        //
       
        return res;
        
    }
}
// improvement to take: no hashmap
