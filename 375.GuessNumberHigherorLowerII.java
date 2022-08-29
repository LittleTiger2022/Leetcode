// s1
class Solution {
    public int getMoneyAmount(int n) {
     int [][] dp = new int [n+1][n+1];
        return minCost(dp,1,n);
    }
    
    private int minCost (int [][] dp, int l, int h) {
        if (l>=h)
            return 0;
        if (l+1==h)
            return 1;
        if (dp[l][h]!=0)
            return dp[l][h];
        int minCost = Integer.MAX_VALUE;
        int mid = (h+l)/2;
        for (int i=h-1;i>=mid;i-=2)
            minCost = Math.min(minCost,i+Math.max(minCost(dp,l,i-1),minCost(dp,i+1,h)));
        dp[l][h] = minCost;
        return minCost;
    }
}
