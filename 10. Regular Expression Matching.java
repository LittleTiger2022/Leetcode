// 6ms
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean [][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for (int j=2; j<=n; j++)
            if (p.charAt(j-1)=='*')
                dp[0][j] = dp[0][j-2];
        
        for (int i=1; i <=m;++i)
            for (int j=1;j<=n;++j)
                if (match(s.charAt(i-1),p.charAt(j-1)))
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    if (match(s.charAt(i-1),p.charAt(j-2)))
                        dp[i][j] = dp[i-1][j] | dp[i][j];
                            
                }
        return dp[m][n];           
                
    }
    boolean match(char a, char b) {
        return a==b || b=='.';
    } 
        
}

// better explaination & concise solution
public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);
        
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=2; j<=p.length(); j++) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2]; 
        }
        
        for (int j=1; j<=p.length(); j++) {
            for (int i=1; i<=s.length(); i++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') 
					dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]); 
            }
        }
        return dp[s.length()][p.length()];
    }
