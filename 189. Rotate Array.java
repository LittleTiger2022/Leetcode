// 2ms
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (nums.length==1) return;
        int [] output = new int[length];
        int rotate = k % length;
        int newIndex = 0;
        for (int i=0; i<length;i++) {
            newIndex = (i + rotate) % length; 
            output[newIndex] = nums[i];
        }
        for (int i=0; i<length;i++)
            nums[i] = output[i];
        
    }
}

//2ms
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (nums.length==1) return;
        int rotate = k % length;

        reverse(nums,0,length-rotate-1);
        reverse(nums,length-rotate,length-1);
        reverse(nums,0,length-1);
    }
    void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
             nums[end]  = temp;
            start++;
            end--;
        }
    }
}
