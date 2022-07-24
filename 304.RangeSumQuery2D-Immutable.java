// my naive solution
// 1636 ms 20% 52.9Mb 99%
class NumMatrix {
    
    private int [][] dp;
        
    public NumMatrix(int[][] matrix) {
        dp = new int [matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++)
                dp[i][j] = matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for (int i=row1;i<=row2;i++)
            for(int j=col1;j<=col2;j++)
                sum+=dp[i][j];
        return sum;
    }
}
// solution 2 DP
// 243 ms (35%) 127 Mb (62%)
class NumMatrix {
    
    private int [][] dp;
        
    public NumMatrix(int[][] matrix) {
        dp = new int [matrix.length+1][matrix[0].length+1];
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++)
                dp[i+1][j+1] = matrix[i][j]+dp[i+1][j]+dp[i][j+1] - dp[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        return dp[row2+1][col2+1]-dp[row2+1][col1]-dp[row1][col2+1]+dp[row1][col1];
    }
}
//

