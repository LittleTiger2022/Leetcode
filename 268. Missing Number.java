// my naive solution
// 9ms
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        if (nums[right]==right) 
            return right+1;
        if (nums[left]>0)
            return 0;
        
        while(left<=right) {
            int mid = (left+right)/2;
            if (mid==nums[mid])
                left = mid+1;
            if (mid<nums[mid])
                right= mid-1;
        }
        return left;
    }
}
// cleaned version 
// 6ms
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        
        while(left<=right) {
            int mid = (left+right)/2;
            if (mid==nums[mid])
                left = mid+1;
            if (mid<nums[mid])
                right= mid-1;
        }
        return left;
    }
}

// the coolest solution is to use XOR
// this a very smart idea: 
// use XOR: a^b^b =a. 0-n should match with index, so the only missing value can be recovery from
// quote ("In this solution, I apply XOR operation to both the index and value of the array. 
// In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index), 
// so in a missing array, what left finally is the missing number.")


class Solution {
    public int missingNumber(int[] nums) {
            int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;

    }
}
