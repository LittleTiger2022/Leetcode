// 24 ms
// 回溯法。每个位置尝试1-9， 然后试下一个位置。失败是设为'.'
// Backtracking method

class Solution {
    public void solveSudoku(char[][] board) {
        if (board==null || board.length==0)
            return;
        solve(board);
    }
    
    private boolean solve(char [][] board) {
        for (int i=0; i<board.length; i++ ) {
            for (int j=0; j <board[0].length; j++) {
                if (board[i][j] =='.') {
                    for (char c= '1'; c<='9'; c++) 
                        if (isValid(board,i,j,c)) {
                        board[i][j]=c;
                        if (solve(board))
                            return true;
                        else
                            board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid (char [][] board, int row, int col, char c) {
        for (int i=0; i<board.length; i++) {
            if (board[i][col]!='.' && board[i][col]==c)
                return false;
            if (board[row][i]!='.' && board[row][i]==c)
                return false;
            if (board[3*(row/3)+i/3][3*(col/3)+i%3]!='.'
               && board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
                return false;
        }
        return true;
    }
    
}
