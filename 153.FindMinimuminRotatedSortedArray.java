//  My stupid solution 
// 20 ms (5%) and 6.5% in space
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0]<nums[n-1])
            return nums[0];
        if(n==2)
            return nums[0]<nums[1] ? nums[0]:nums[1];
        
        int left = 0, right = n-1;
        int min = Integer.MAX_VALUE;
        
        while (left<=right) {
            int mid = (left+right)/2;
            if (nums[mid]>=nums[left])
                left = mid;
            if (nums[mid]<=nums[right])
                right = mid;
                min = Math.min(min,nums[mid]);
             if (right-left<2) {
                 min = Math.min(min,nums[right]);
                 min = Math.min(min,nums[left]);
                 break;
             }
       System.out.println("left " + left + " right = " + right + " mid = " + mid + " min = "+ min);

        }
        return min;
    }
}

// best solution
// 0ms (100%)
class Solution {
    public int findMin(int[] nums) {
        
        int left =0, right = nums.length-1;
        while (left<right) {
            int mid = (left+right)/2;
            if (nums[mid]<nums[right])
                right = mid;
            else if (nums[mid]> nums[right])
               left = mid+1;
            else
                right--;
                
             }

        return nums[left];
    }
}
