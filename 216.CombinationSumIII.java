// s1
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        int minSum = 0, maxSum=0;
        for (int i=1;i<=k;i++) {
            minSum+=i;
            maxSum+= 9+1-i;
        }
        if (minSum>n || maxSum<n) 
            return res;
        
        combination(res, new ArrayList<Integer>(), k,1,n);
        return res;
    }
    
    private void combination(List<List<Integer>> res,ArrayList<Integer> comb, int k, int start, int n ) {
        if (comb.size()==k && n==0) {
            List<Integer> li = new ArrayList<Integer> (comb);
            res.add(li);
            return;
        }
        
        for(int i=start;i<=9;i++) {
            comb.add(i);
            combination(res,comb,k,i+1,n-i);
            comb.remove(comb.size()-1);
        }
    }
}

// s2
