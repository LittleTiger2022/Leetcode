// solution 1 (with detailed debug print out lines)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int nRow = obstacleGrid.length;
        int nCol = obstacleGrid[0].length;
                
        int [][] table = new int [nRow][nCol];
        
        if (obstacleGrid[0][0]==1) 
            table[0][0] = 0;
        else  table[0][0] = 1;
        
        for (int i=1;i<nRow;i++) {
           
            if (obstacleGrid[i][0]==1) table[i][0] = 0;
             else
                 table[i][0] = table[i-1][0];
        }
        for (int i=1;i<nCol;i++) {
           
             if (obstacleGrid[0][i]==1) table[0][i] = 0;  
             else table[0][i] = table[0][i-1];
        }
        
        for (int i=1;i<nRow;i++) {
            for (int j=1;j<nCol;j++) {
               
                 if (obstacleGrid[i][j]==1) {
                table[i][j] = 0;     
            } else
                      table[i][j] = table[i-1][j] + table[i][j-1];
            }
        }
      
        return table[nRow-1][nCol-1]; 
        
    }
}
// offical solution
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }
}
