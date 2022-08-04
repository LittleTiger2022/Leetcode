//s1
// O(n) 6ms 85% 55Mb 54%
class Solution {
    public void wiggleSort(int[] nums) {
       int n=nums.length-1;
        //copy values to new array
       int[] newarr=Arrays.copyOf(nums,nums.length);
        //sort new array
       Arrays.sort(newarr);
        
        for(int i=1;i<nums.length;i+=2)
            nums[i]=newarr[n--];
        //even position
        for(int i=0;i<nums.length;i+=2)
            nums[i]=newarr[n--];
    }
}
