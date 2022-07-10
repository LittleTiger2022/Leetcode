// my naive solution
// 1ms (100%) 41Mb (50%)
class Solution {
    public int fillCups(int[] amount) {
        int count =0;
        while (amount[0]>0 || amount[1]>0 || amount[2]>0) {
           sortArray(amount);
    //      System.out.println(Arrays.toString(amount));
            if (amount[0]>0 && amount[1] >0) {
                amount[0]--;
                amount[1]--;
                count++;
            }
            else if (amount[0]>0 && amount[1]==0) {
                amount[0]--;
                count++;
            }
            
            if (amount[0]==0 && amount[1]==0 && amount[2]==0)
                break;
        }
        return count;
    }
    public void sortArray(int [] nums) {
        if (nums[1]>nums[0]) {
            int tmp = nums[0];
            nums[0]= nums[1];
            nums[1] = tmp;
        }
        if (nums[2]>nums[0]) {
            int tmp = nums[0];
            nums[0] = nums[2];
            nums[2] = nums[1];
            nums[1] = tmp;
        }
         if  (nums[2]>nums[1]) {
            int tmp = nums[1];
            nums[1]= nums[2];
            nums[2] = tmp;
        }
        
    }
}

// s2: use priority queue
// 11 ms (20%)
class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<amount.length;i++){
            if(amount[i]==0)continue;
            pq.add(amount[i]);
        }
        int days = 0;
        while(!pq.isEmpty()){
            int last = pq.poll();
            if(pq.isEmpty()){
                return days+last;
            }
            int secondLast =  pq.poll();
            days++;
            last--;
            secondLast--;
             if(last>0)pq.add(last);
            if(secondLast>0)pq.add(secondLast);
        }
        return days;
    }
}
