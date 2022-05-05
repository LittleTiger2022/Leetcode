// 9ms
// solution 1: (backtrack)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        int n = candidates.length;
        for (int i=0; i<n; i++) {
            List<Integer> candidateL = new ArrayList<Integer>();
            candidateL.add(candidates[i]);
            backTrack(candidates,i,candidates[i],candidateL,target,r);
        }
        return r;
    }
    
    private static void backTrack (int [] nums, int i, int sum, List<Integer> candidateL,int target,
                                  List<List<Integer>> r) {
        if (sum>target)
            return;
        if(sum==target) {
            List<Integer> newL = new ArrayList<Integer>();
            newL.addAll(candidateL);
            r.add(newL);
            return;
         }
        for (int j=i; j< nums.length;++j) {
            candidateL.add(Integer.valueOf(nums[j]));
            sum+=nums[j];
            backTrack(nums,j,sum,candidateL,target,r);
            candidateL.remove(Integer.valueOf(nums[j]));
            sum-=nums[j];
        }
        
    }
}

//
