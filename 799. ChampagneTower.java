

// 2D dynamic Programming
// 7ms, 46.5Mb
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
       double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = poured;
        for (int i = 0; i < query_row; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (dp[i][j] >1) {
                    dp[i + 1][j] += (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j + 1] += (dp[i][j] - 1) / 2.0;
                }
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
        }
        
}

// 1D DP
// 6ms, 47.7Mb
class Solution {
  public double champagneTower(int poured, int query_row, int query_glass) {
    double[] dp = new double[query_row + 1];
    dp[0] = poured;

    for (int i = 0; i < query_row; ++i) {
      double[] newDp = new double[query_row + 1];
      for (int j = 0; j <= i; ++j)
        if (dp[j] > 1) {
          newDp[j] += (dp[j] - 1) / 2.0;
          newDp[j + 1] += (dp[j] - 1) / 2.0;
        }
      dp = newDp;
    }

    return Math.min(1.0, dp[query_glass]);
  }
}

// Elegent solution
class Solution {
    int poured;
    Double[][] memo;
    public double champagneTower(int poured, int query_row, int query_glass) {
        this.poured = poured;
        this.memo = new Double[query_row+1][query_glass+1];
        double ans = dp(query_row, query_glass);
        return Math.min(1, ans);
    }
    
    // dp(r, c) means the amount of champagne is poured into cup[r, c]
    double dp(int r, int c) {
        if (c < 0 || c > r) return 0; // Invalid position
        if (r == 0 && c == 0) return poured; // Amount Champaign is poured into the top cup
        if (memo[r][c] != null) return memo[r][c];
        return memo[r][c] = Math.max(dp(r-1, c-1) - 1, 0) / 2 + Math.max(dp(r-1, c) - 1, 0) / 2;
    }
}

// normal solution
// *Intuition
//Instead of keeping track of how much champagne should end up in a glass, keep track of the total amount of champagne that flows through a glass. For example, if poured = 10 cups are poured at the top, then the total flow-through of the top glass is 10; the total flow-through of each glass in the second row is 4.5, and so on.

// *Algorithm

// In general, if a glass has flow-through X, then Q = (X - 1.0) / 2.0 quantity of champagne will equally flow left and right. We can simulate the entire pour for 100 rows of glasses. A glass at (r, c) will have excess champagne flow towards (r+1, c) and (r+1, c+1).
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);
    }
}
