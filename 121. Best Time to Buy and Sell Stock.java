// DP
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int min = prices[0], max = 0;
        for (int i=1;i<prices.length;i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
// cumulative sumation
// also named as Kadane's Algorithm
class Solution {
    public int maxProfit(int[] prices) {
        int maxCur=0,maxSoFar = 0;
        for (int i=1;i<prices.length;i++) {
            maxCur = Math.max(0,maxCur+=(prices[i] -prices[i-1] ));
            maxSoFar = Math.max(maxCur,maxSoFar);
        }
        return maxSoFar;
    }
}
//
