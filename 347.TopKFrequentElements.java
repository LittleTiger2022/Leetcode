// use PriorityQueue
// 15 ms (75%) 50 Mb (37%)
// O(klogN)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> freqMap = new HashMap<>();
        
        
        for (int num:nums) 
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> freqMap.get(b) - freqMap.get(a));
    
        for (int key:freqMap.keySet()) {
            maxHeap.add(key);
        }
        
        int [] res = new int [k];
        for (int i=0;i<k;i++) {
            res[i] = maxHeap.poll();
        }
                 
        return res;
        
    }
}
// solution 2: use bucket sorting
// 17 ms (63%)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> freqMap = new HashMap<>();
        
        for (int num:nums) 
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        
     List<Integer> bucket[] = new ArrayList[n];
        
        for (int key:freqMap.keySet()) {
            int freq = freqMap.get(key)-1;
            if (bucket[freq]==null) 
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        int res[] = new int[k];
        int index = 0;
        for (int i=n-1;i>=0;i--) {
            if (bucket[i]!=null){
                for (int val: bucket[i]) {
                    res[index++] = val;
                    if (index==k) return res;
                }
            }
        }
        return res;
                         
    }
}
