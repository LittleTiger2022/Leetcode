//s1: DP
// 2ms (90%), 41Mb (88%) O(kn)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n<1)
            return 0;
        if (k>=n/2)
            return maxCum(prices);
        int [] balance = new int[k+1];
        Arrays.fill(balance, Integer.MIN_VALUE);
        int [] profit = new int[k+1];
        
        for (int price:prices) {
            for (int j=1;j<=k;j++) {
                balance[j] = Math.max(profit[j-1]-price,balance[j]);
                profit[j] = Math.max(balance[j]+price,profit[j]);
            }
        }
        return profit[k];
    }
    
    int maxCum(int [] prices) {
        int ans = 0;
        for (int i=0;i<prices.length-1;i++)
            if (prices[i+1]>prices[i])
                ans +=prices[i+1] -prices[i];
        return ans;
    }
}

