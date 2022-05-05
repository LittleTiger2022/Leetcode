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

// one easier to understand backtracking version
// 10 ms
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        backtrack(candidates,0,target,new ArrayList(), res);
        return res;
    }
    private void backtrack(int [] cand, int start,int target,List<Integer> list, List<List<Integer>> res){
        if (target<0)
            return;
        if (target==0) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i=start;i<cand.length;i++){
            list.add(cand[i]);
            backtrack(cand,i,target-cand[i],list,res);
            list.remove(list.size()-1);
        }    
    }
}
