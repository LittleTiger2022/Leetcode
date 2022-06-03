//
class Solution {
    public int numIslands(char[][] grid) {
        int ans=0,m=grid.length;
        if (m==0)
            return ans;
        int n = grid[0].length;
        for ( int i=0;i<m;++i) {
            for ( int j=0;j<n;++j) {
                if (grid[i][j]=='1') {
                    dfs(grid,i,j);
                    ++ans;
                }
            }
        }
        return ans;
    }
    
    void dfs(char [][] grid, int i, int j) {
        if (i==-1 || j==grid[0].length || j==-1 || i == grid.length || grid[i][j]!='1')
            return;
        grid[i][j] = '2';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid, i,j+1);
        dfs(grid,i,j-1);
    }
}
