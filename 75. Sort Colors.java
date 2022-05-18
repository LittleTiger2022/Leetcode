// 0ms three colors
class Solution {
    public void sortColors(int[] nums) {
        int [] count = new int [3];
        for (int i=0; i<nums.length;i++) {
            if (nums[i]==0) count[0]++;
            if (nums[i]==1) count[1]++;
            if (nums[i]==2) count[2]++;
        }
       
        for (int i=0;i<count[0];i++) 
             nums[i] = 0;
         int curID = count[0];    
        for (int i=curID;i<curID+count[1];i++)
            nums[i]  = 1;
        curID = curID + count[1];
        for (int i=curID; i<curID + count[2];i++)
            nums[i] = 2;
        
    }
}
//solution 2: only consider n-1 color (so two colors)
class Solution {
    public void sortColors(int[] nums) {
        int [] count = new int [2];
        for (int i=0; i<nums.length;i++) {
            if (nums[i]==0) count[0]++;
            if (nums[i]==1) count[1]++;
        }
       
        for (int i=0;i<count[0];i++) 
             nums[i] = 0;
         int curID = count[0];    
        for (int i=curID;i<curID+count[1];i++)
            nums[i]  = 1;
        curID = curID + count[1];
        for (int i=curID; i<nums.length;i++)
            nums[i] = 2;
        
    }
}
// a more concise solution
class Solution {
    public void sortColors(int[] nums) {
        int r =0, w=0;
        for (int i=0; i<nums.length;i++) {
            if (nums[i]==0) r++;
            if (nums[i]==1) w++;
        }
       
        for (int i=0;i<r;i++) 
             nums[i] = 0;
        for (int i=r;i<r+w;i++)
            nums[i]  = 1;
        for (int i=r+w; i<nums.length;i++)
            nums[i] = 2;
        
    }
}
