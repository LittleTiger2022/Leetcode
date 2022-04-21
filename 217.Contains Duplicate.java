// 14 ms
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length;i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i],i);
        }
        return false;
    }
}

// use dict, 4ms
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            if (!numSet.add(num)) return true;
        }
        return false;
    }
}
