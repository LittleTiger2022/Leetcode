// 2 ms
class Solution {
    public void solve(char[][] board) {
     int m = board.length, n = board[0].length;
        if (m<=2 || n<=2  ) return;
        // mark "o" and linked "o" at boundary with "*"
        for (int i=0;i<m;i++) {
            if (board[i][0]=='O')
                dfs(board,i,0);
            if (board[i][n-1]=='O')
                dfs(board,i,n-1);
            }
         for (int i=0;i<n;i++) {
            if (board[0][i]=='O')
                dfs(board,0,i);
            if (board[m-1][i]=='O')
                dfs(board,m-1,i);
            }
        
        for (int i=0;i<m; i++) 
            for (int j = 0; j<n;j++ ) {
                if (board[i][j]=='O')
                    board[i][j] = 'X';
                else if (board[i][j] == '+')
                    board[i][j] =  'O';
            }
                
    }
    void dfs(char [][] board, int i, int j) {
        if (i<0 || i> board.length-1 || j <0 || j > board[0].length-1 || board[i][j]=='X' || board[i][j]=='+')
            return;
            board[i][j] ='+';
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board, i,j-1);
    }
    
}
