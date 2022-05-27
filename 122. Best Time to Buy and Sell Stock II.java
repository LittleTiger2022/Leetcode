// 2ms
class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0, profit = 0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i]>buy) {
                sell=prices[i];
                profit += sell-buy;
                buy = sell;            
            } else buy = prices[i];
            
        }
        return profit;
    }
}
// sumation of positive difference between seccessiveful days
// note: the easiest leetcode question I have ever faced with
class Solution {
    public int maxProfit(int[] prices) {
        int sumation = 0;
        for (int i=1;i<prices.length;i++) {
            if (prices[i]>prices[i-1])
                sumation = sumation +  (prices[i]- prices[i-1]);
        }
        return sumation;
    }
}
