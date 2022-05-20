// backtrack method
// for input [1,2,3]
// output [[], [1], [1,2],[1,2,3],[1,3],[2],[2,3],[3]]
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums,0);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i=start;i<nums.length;i++) {
            tempList.add(nums[i]);
            backtrack(list,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
// lexicographic (Binary Sorted) Subsets
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        
             //   int nthBit = 1<< n;
    //    for (int i=0;i<(int)Math.pow(2,n);i++) {
    //        String bitmask = Integer.toBinaryString( i | nthBit).substring(1);
        
        for (int i = (int) Math.pow(2,n); i< (int) Math.pow(2,n+1);++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            
            List<Integer> curr = new ArrayList();
            
            for (int j=0;j<n;j++) {
                if (bitmask.charAt(j)=='1') curr.add(nums[j]);
                
            }
        
        list.add(curr);
        }
        return list;
    }
}
//
