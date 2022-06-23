// s1
// DP  5ms 60%
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m= s1.length(), n = s2.length(), o = s3.length();
        if (m+n!=o)
            return false;
        boolean [][] res = new boolean[m+1][n+1];
        res[0][0] = true;
        
     for (int i=1;i<=m;++i)
         res[i][0]= res[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for (int i=1;i<=n;++i)
            res[0][i] = res[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        for (int i=1;i<=m;++i)
            for (int j=1;j<=n;++j)
                res[i][j] = (res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1 )) || (res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
        return res[m][n];
    }
}
