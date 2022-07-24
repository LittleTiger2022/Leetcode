// use status tranfer diagram
// 1ms 93% 42.5Mbs 31%
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<2)
            return 0;
        
        int hold = Integer.MIN_VALUE, rest=0, sold=0;
        int hold1, sold1, rest1;
        
        for (int price:prices) {
            hold1 = Math.max(hold, rest-price);
            sold1 = hold + price;
            rest1 = Math.max(rest,sold);
            // update status
            hold = hold1;
            sold = sold1;
            rest = rest1;
        }
        return Math.max(rest,sold);
        
    }
}

