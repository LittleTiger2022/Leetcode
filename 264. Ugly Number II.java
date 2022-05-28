//
class Solution {
    public int nthUglyNumber(int n) {
        int [] ugly = new int [n];
        ugly[0] = 1;
        if (n>1){
            int index2 =0, index3=0, index5=0;
            int factor2 = 2, factor3= 3, factor5= 5;
            
            for (int i=1;i<n;i++) {
                int min = Math.min(Math.min(factor2,factor3),factor5);
                ugly[i] = min;
                if (factor2==min)
                    factor2 = 2*ugly[++index2];
                if (factor3==min)
                    factor3 = 3*ugly[++index3];
                if (factor5==min)
                    factor5 = 5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}
// use TreeNode 161 ms
public class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> ans = new TreeSet<>();
        ans.add(1L);
        for (int i = 0; i < n - 1; ++i) {
            long first = ans.pollFirst();
            ans.add(first * 2);
            ans.add(first * 3);
            ans.add(first * 5);
        }
        return ans.first().intValue();
    }
}
// shortest run time (2ms)
class Solution {
   public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1]; // dp[i] holds the ith's ugly number
        dp[1] = 1;
        int p2=1, p3=1, p5=1;
        for(int i=2; i<=n; i++){ // loop invariant:dp[i] holds the smallest ith uglynumber
            dp[i] = Math.min(2*dp[p2], Math.min(3*dp[p3],5*dp[p5])); // the next ugly number must be built from a smaller ugly number
            if(dp[i]==2*dp[p2])p2++; 
            if(dp[i]==3*dp[p3])p3++;
            if(dp[i]==5*dp[p5])p5++;
        }
        return dp[n];
    }
}
