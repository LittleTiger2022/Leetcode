// 1ms
// use snowball idea (similar to LT283)
class Solution {
    public int removeDuplicates(int[] nums) {
        int snowball = 0;
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]) snowball++;
            else
             nums[i+1-snowball] = nums[i+1];
        }
        return nums.length- snowball;
    }
}
