// use hashset
// O(n) 18ms; space O(n)

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num))
                return num;
            seen.add(num);
        }
        return -1;
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        int ans=0;
        for (int num:nums) {
            if(!numSet.add(num))
            {
                ans=num;
                break;
            }
        }
        return ans;
    }
}
// Negative Marking (a smart way to slip number to make use the fact: nums in 1:n, all positive)
// for the same location (dup case) if the number is already flagged as negative, given nums[i] as index, then nums[i] is the dup number.
// O(n) 6ms
class Solution {
    public int findDuplicate(int[] nums) {
        int dup=-1;
        for (int i=0;i<nums.length;i++) {
            int id = Math.abs(nums[i]);
            if ( nums[id]<0) {
                dup = Math.abs(nums[i]);
                break;
            } else
                nums[id] = -1*nums[id];
        }
        
        // restore to be all positive
        for (int i=0;i<nums.length;i++)
            nums[i] = Math.abs(nums[i]);
    
    return dup;
}
}
//
