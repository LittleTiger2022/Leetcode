// s1
// 3ms (42%) 43Mb (87%)
class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums.length==2)
            return nums;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int i=0;i<nums.length;i++)
            if (map.containsKey(nums[i]))
                map.remove(nums[i]);
            else
                map.put(nums[i],1);
       int [] res = new int [2];
        int i=0;
        for (Map.Entry<Integer,Integer> mapEntry: map.entrySet()) {
            res[i] = mapEntry.getKey();
            i++;
        }
        return res;
    }
}
//
// 1ms, 100% , 91%
class Solution {
    public int[] singleNumber(int[] nums) {
        int diff=0;
        for (int num: nums)
            diff^=num;
        diff &= -diff;
        int [] res = {0,0};
        for (int num:nums) {
            if ((num & diff)==0)
                res[0] ^=num;
            else
                res[1]  ^=num;
        }
        return res;
    }
}
//

