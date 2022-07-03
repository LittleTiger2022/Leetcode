// 52 ms, 45.1Mb
class Solution {
    public int[] twoSum(int[] nums, int target) {
         int[] arr = new int[2];
        for (int i=0;i<(nums.length-1);i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+ nums[j] == target)
                {
                     arr[0]=i;
                    arr[1] = j;
                    
                }
            }
        }
     return arr;
    }
}

// 1ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]))
                return new int[] {map.get(nums[i]),i};
            map.put(target - nums[i],i);
        }
        throw new RuntimeException("No result");
    }
}

// 
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            final Integer complement = m.get(target-nums[i]);
            if (complement != null && complement > i) {
                return new int[]{i, complement};
            }
        }
        return null;
    }
};

// single recursion
// Two Sum
// 方法2：HashMap + 单次遍历。用一个哈希表，存储每个数对应的下标
// Time Complexity: O(n)，Space Complexity: O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final Integer complement = m.get(target-nums[i]);
            if (complement != null) {
                return new int[]{i, complement};
            }
            m.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
};
