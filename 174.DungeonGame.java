// s1
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int [][] h = new int[m][n];
        h[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);
        for (int i=m-2;i>=0;i--)
            h[i][n-1] = Math.max(1,h[i+1][n-1] - dungeon[i][n-1]);
        for (int j = n-2;j>=0;j--)
            h[m-1][j] = Math.max(1,h[m-1][j+1] - dungeon[m-1][j]);
        
        for (int i=m-2;i>=0;i--)
            for (int j=n-2;j>=0;j--)
                h[i][j] = Math.min(Math.max(1,h[i+1][j] - dungeon[i][j]),
                                   Math.max(1,h[i][j+1]-dungeon[i][j]));
       return h[0][0];                            
    }
}

//

