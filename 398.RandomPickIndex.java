//s1
// 183 ms (24%) 85Mb (48%)
class Solution {
    Map<Integer, List<Integer>> hm = new HashMap<>();
    
    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i])) 
                hm.put(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indice = hm.get(target);
        if(indice.size() > 1) {
            Random rand = new Random();
            int index = rand.nextInt(indice.size());
            return indice.get(index);
        } else 
            return indice.get(0);
    }
}
// s2: 133ms, 81Mb
class Solution {
    //O(n) time | O(n) space
    Map<Integer, List<Integer>> map;
    Random rand;
    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for(int i=0; i<nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}
