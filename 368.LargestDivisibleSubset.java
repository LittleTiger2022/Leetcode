//s1
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
     List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums);
        int n = nums.length;
        int [] count = new int [n];
        int [] preNum = new int [n];
        Arrays.fill(count,1);
        Arrays.fill(preNum,-1);
        int max = Integer.MIN_VALUE, index = -1;
        for (int i=0;i<n;++i) {
            for (int j=0;j<i;++j) {
                if (nums[i]%nums[j]==0 && count[j]+1>count[i]) {
                    count[i]=count[j]+1;
                    preNum[i] = j;
                }
            }
        if (count[i]>max) {
            max = count[i];
            index = i;
        }
    }
        for (int i=index; i !=-1;i=preNum[i])
            ans.add(nums[i]);
        return ans;
    }
}
