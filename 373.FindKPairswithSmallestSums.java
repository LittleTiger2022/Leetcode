//s1
class Solution {
    class Pair implements Comparable <Pair> {
        int x,y, sum;
    public Pair (int x, int y, int sum) {
        this.x = x;
        this.y =y;
        this.sum = sum;
    }
    @Override
    public int compareTo(Pair that) {
        return this.sum - that.sum;
    }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
     List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0)
            return result;
        
        PriorityQueue <Pair> pQueue = new PriorityQueue<>();
        
        int len1 = nums1.length, len2 = nums2.length;
        for (int i=0;i<len2;i++) {
            pQueue.offer(new Pair(0,i,nums1[0]+nums2[i]));
        }
        for (int i=0;i<Math.min(k,len1*len2);i++) {
            Pair p = pQueue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[p.x]);
            list.add(nums2[p.y]);
            result.add(list);
            if (p.x==len1-1)
                continue;
            pQueue.offer(new Pair(p.x+1,p.y,nums1[p.x+1]+ nums2[p.y]));
        }
        return result;
    }
}
//

