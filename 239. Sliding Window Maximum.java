// use Deque ArrayDeque to dynamically contain the k array values.
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k==1) return nums;
        int ri=0;
        int []  res = new int [nums.length - k+1];
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i=0;i< nums.length;i++) {
            if (!q.isEmpty() && q.peek()<i-k+1)
                q.poll();
            while (!q.isEmpty() && nums[q.peekLast()]<nums[i])
                q.pollLast();
            q.offer(i);
            if (i>=k-1)
            res[ri++] = nums[q.peek()];
        }
        return res;
    }
    
}

