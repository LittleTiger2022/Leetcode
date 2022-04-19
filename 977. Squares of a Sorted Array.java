// first try (traditionl sorting for part less than 0)
// 1194ms
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, temp=0;
        int[] res = new int[n];
        
        for (int i=0; i<n; i++) {
            if (nums[i]<0) {
            for (int j=i+1; j <n; j++) {
             if (Math.abs(nums[i])> Math.abs(nums[j])) {
                 temp = nums[j];
                 nums[j] = nums[i];
                 nums[i] = temp;
             }   
            }
            }
                 res[i] = nums[i]*nums[i];
              
        }
        return res;
    }
}

// 2ms
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int lo = 0, hi =  nums.length-1;
        for (int i=nums.length-1; i>=0; i--) {
            
            if (Math.abs(nums[lo])> Math.abs(nums[hi])) {
                res[i] = nums[lo]*nums[lo];
                lo++;
            }
            else { res[i] = nums[hi]*nums[hi];
                  hi--;
                 }
        }
        return res;
    }
}
