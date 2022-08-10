// s1
// O(n)
class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> Seen = new HashSet<>();
        int [] res = new int [2];
        int sum = 0;
        for (int i=0;i<nums.length;i++) {
            if (Seen.contains(nums[i])) {
                res[0] = nums[i];
            }
            Seen.add(nums[i]);
            sum+=nums[i];
                
        }
        res[1] = (nums.length+1)*nums.length/2-sum+res[0];
        return res;
        
    }
}
// s2:
// O(n) 16 ms 22% 55Mb 27%
class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int [] res = new int [2];
        int sum = nums[0];
        for (int i=1;i<nums.length;i++) {
           if (nums[i]-nums[i-1]==0)
                res[0] = nums[i];
            sum+=nums[i];
        }
        res[1] = (nums.length+1)*nums.length/2-sum+res[0];
        return res;
        
    }
}
// s3
// O(n) 5 ms (38%) 54.5Mb (65%)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int [] res = new int [2];
        int sum=0;
        for (int i : nums) {
            sum+=Math.abs(i);
        if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
    	else nums[Math.abs(i) - 1] *= -1;
            
         }
        res[1] = (nums.length+1)*nums.length/2-sum+res[0];
        return res;
        
    }
}
//


