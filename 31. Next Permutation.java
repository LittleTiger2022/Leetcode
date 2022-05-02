// naive approach (Consider two cases: 1) nums[i]>nums[i-1] at the end, simple exchange;
// 2) nums[i]>nums[i-1] in the middle. search from i to nums.length-1 for the smallest nums[j] > nums[i-1], and exchange. Thenafter, partially sort nums[i,nums.length]
// If nothing can be exchanged, reverse the order.
//
// 2ms
class Solution {
    public void nextPermutation(int[] nums) {
        int exchangeable =0;
        for (int i=nums.length-1;i>0;i--) {
            if (nums[i]>nums[i-1]) {
                exchangeable = 1;
                if (i==nums.length-1) {
              
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
                 break;}
            else if ( i<nums.length-1) {
                int minJ = nums[i], minJID = i;
                for (int j=i+1;j<=nums.length-1;j++) {
                    if (nums[j]>nums[i-1] && nums[j]<minJ)
                    {
                        minJ = nums[j];
                        minJID = j;
                    }
                    
                }
                int temp = nums[i-1];
                nums[i-1] = nums[minJID];
                nums[minJID] = temp;
                // sort from i to nums.length
                Arrays.sort(nums, i, nums.length);
                break;
                    }
                }
               
            }
        if (exchangeable==0) {
            reverse(nums, nums.length);
        }
    }
    public static void reverse(int a[], int n)
    {
        int i, k, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
}


// a better solution
// idea: search backward. find the next value that is larger than the i-1 th value and swap. Then reverse the orde from i to nums.length-1.
// 0 ms
class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for (i=nums.length-1;i>0;--i)
            if (nums[i]>nums[i-1])
                break;
        if (i>0)
            for (int j=nums.length-1;j>=i;--j)
                if (nums[j]>nums[i-1]) {
                    swap(nums,j,i-1);
                    break;
                }
        reverse(nums,i,nums.length-1);
    }
    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void reverse(int [] nums, int i, int j){
        while (i<j)
            swap(nums,i++,j--);
    }
}
