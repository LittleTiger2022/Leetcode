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
