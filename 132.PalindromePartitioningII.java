// s1
// 1 ms
class Solution {
    public int minCut(String s) {
        int n = s.length();
        char [] t = s.toCharArray();
        int [] dp = new int [n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        int i = 0;
        while (i<n) {
            expandAround(t,i,i,dp);
            expandAround(t,i,i+1,dp);
            i++;
        }
        return dp[n];
    }
    public void expandAround(char [] t, int i, int j, int [] dp) {
        while (i>=0 && j< t.length && t[i] == t[j]) {
            dp[j+1] = Math.min(dp[j+1],dp[i]+1);
            i--;
            j++;
        }
    }
}

// s2:
// 17 ms
class Solution {
    public int minCut(String s) {
       int len = s.length();
        char [] c = s.toCharArray();
        int [] dp = new int [len+1];
        boolean [][] p = new boolean [len+1][len+1];
        for (int i=1;i<=len;i++) {
            dp[i] = i;
            for (int j=1;j<=i;j++) {
                if ((c[j-1] == c[i-1]) && (j+1>i-1 || p[j+1][i-1])) {
                    p[j][i] = true;
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        return dp[len] -1;
    }
}
