// 6ms DP (Dynamic Programming) for minimum edit distance problem
// (insertion, deletion and substitution)
//
class Solution {
    public int minDistance(String word1, String word2) {
        char [] wc1 = word1.toCharArray();
        char [] wc2 = word2.toCharArray();
        
        int m = wc1.length, n = wc2.length;
        
        if (m==0 || n ==0)
            return m+n;
        
        int [][] ans = new int[m+1][n+1];
        
        ans[0][0] = 0;
        
    
        for (int i=1;i<=m;i++)
            ans[i][0] = ans[i-1][0] +1;
        
        for (int i=1;i<=n;i++)
            ans[0][i] = ans[0][i-1]+1;
        
        for (int i=1;i<=m;++i) 
            for (int j=1;j<=n;++j)
                ans[i][j] = Math.min(Math.min(ans[i-1][j], ans[i][j-1]),
                            ans[i-1][j-1] - (wc1[i-1]==wc2[j-1]?  1:0)) +1;
        return ans[m][n];
    }
}
