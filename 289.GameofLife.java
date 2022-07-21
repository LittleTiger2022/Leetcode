// my naive solution
// 0 ms 100% 42Mb (76%)
class Solution {
    public void gameOfLife(int[][] board) {
       int nRow = board.length;
       int nCol = board[0].length;
        
       int [][] temp = new int [nRow][nCol];
        
        //System.out.println(nRow + "  " + nCol);
        
       for (int i=0;i<nRow;i++)
           for (int j=0;j<nCol;j++)
               temp[i][j] = board[i][j];
        
        // apply the four criteria
       for (int i=0;i<nRow;i++) {
           for (int j=0;j<nCol;j++)  {
           //    System.out.println("i = " + i + " j = " + j);
             int neighbour = 0;
              if (i>0 & j>0)
                 neighbour+=temp[i-1][j-1];
              if (i+1<nRow & j+1<nCol)
                 neighbour+=temp[i+1][j+1];
              if (i>0)
                  neighbour+=temp[i-1][j];
              if(j>0)     
                  neighbour+=temp[i][j-1];
               if(i<nRow-1)
                   
                  neighbour+=temp[i+1][j]; 
               if (j<nCol-1)
                   neighbour+=temp[i][j+1];
               if (i>0 & j<nCol-1)
                   neighbour+=temp[i-1][j+1];
               if (i<nRow-1 & j>0)
                   neighbour+=temp[i+1][j-1];
               
               if (neighbour<2) 
                   board[i][j]= 0;
               //if (neighbour==2 | neighbour==3)
               // do nothing
               if (neighbour>3)
                   board[i][j] = 0;
               if (board[i][j] == 0 & neighbour==3)
                   board[i][j]=1;
                   
           }
           }
        
    }
}
// in place solution
// 0->2 ; 1->3
// 1 ms (61%) 
class Solution {
    public void gameOfLife(int[][] board) {
    if (board == null || board.length==0)
        return;
        int m = board.length, n =board[0].length;
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
             int lives = liveNeighbors(board,m,n,i,j);       
             if (board[i][j] ==1 && lives>=2 && lives <=3)
                 board[i][j] = 3;
             if (board[i][j]==0 && lives==3)
                 board[i][j] = 2;
            }
        }
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                board[i][j] >>= 1;
            }
        }
        
    }
    public int liveNeighbors( int [][] board, int m, int n, int i, int j) {
     int lives =0;
        for (int x=Math.max(i-1,0);x<=Math.min(i+1,m-1);x++)
            for (int y = Math.max(j-1,0); y<=Math.min(j+1,n-1);y++)
                lives += board[x][y] & 1;
        lives -= board[i][j] & 1;
        return lives;
    }
}
