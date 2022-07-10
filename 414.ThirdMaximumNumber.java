// solution 1: brute-force method
// time O(n+n+n) 2 ms (83%) space O(4) 64%
class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        int third  = Integer.MIN_VALUE;
        
        for (int i=0;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i]<max)
              second = Math.max(second,nums[i]);
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i]<second)
                third = Math.max(third,nums[i]);
        }
        if (third>=min && third<second && second < max)
            return third;
        else
            return max;
        
    }
}

// simplified solution
// time O(n) 1ms (97%) space O(1) 75%
class Solution {
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        int third  = Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++) {
            
            if (max<nums[i]) {
                third = second;
                second = max;
                max = nums[i];
            }
            
            if (nums[i]<max && nums[i]> second) {
                third = second;
                second = nums[i];
            }
            
            if (nums[i]<second && nums[i]>third)
                third = nums[i];
           
            min = Math.min(min,nums[i]);
        }
        
        
        
        if ( third>=min && third<second && second < max)
            return third;
        else
            return max;

    }
}
"

// use HashSet and TreeSet
// time O(nlogn) 17 ms (10%) 45Mb (7%)
class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            set.add(nums[i]);
            max = Math.max(max,nums[i]);
        }
        
        if (set.size()<3)
            return max;
        else {
        TreeSet sorted = new TreeSet<Integer>(set);
        int n = sorted.size();
        Object [] arr = sorted.toArray();
        return (Integer) arr[n-3];
        }
        
    }
}
// purely use Set method
// 24 ms
class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++) 
            set.add(nums[i]);
        TreeSet sorted = new TreeSet<Integer>(set);
        int n = sorted.size();
        Object [] arr = sorted.toArray();
        
        if (n>=3)
            return (Integer) arr[n-3];
        else 
            return (Integer) arr[n-1];
        
    }
}
// use PriorityQueue
// 4 ms (65%) 43Mb (60%)
class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) {
            if(pq.size() < 3 && !pq.contains(n)) {
                    pq.add(n);
            } else if(!pq.contains(n) && n > pq.peek()) {
                pq.poll();
                pq.add(n);
            }
        }
        
        if(pq.size() < 3)
            while(pq.size() > 1)
                pq.poll();
        
        return pq.poll();
    }
}

