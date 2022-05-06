// backtrack method

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums==null || nums.length==0)
            return res;
        backtrack(nums,new boolean[nums.length],new ArrayList<>(),res);
        return res;
            
        }
    private void backtrack(int [] nums, boolean [] visited, List<Integer> cl, 
                           List<List<Integer>> res) {
        if (cl.size()==nums.length){
            res.add(new ArrayList<>(cl));
            return;
        }
        for (int i=0; i< nums.length; i++){
            if (visited[i] )
                continue;
            cl.add(nums[i]);
            visited[i] = true;
            backtrack(nums,visited,cl,res);
            cl.remove(cl.size()-1);
            visited[i] = false;
        }
    }
}
