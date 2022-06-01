// smart solution
class Solution {
    public int majorityElement(int[] nums) {
        int count=0,idx=0;
        for (int i=0;i<nums.length;i++) {
            if (count==0) idx=i;
            if (nums[i]==nums[idx])
                count++;
            else
                count--;
        }
        return nums[idx];
    }
}
