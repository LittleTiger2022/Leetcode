// use what we have from 51, do not return with string array, but total number of cases
// note: need to define the totalNQ outside of the class "totalNQueens"
// 8 ms
class Solution {
    int totalNQ = 0;
    public int totalNQueens(int n) {
    char [][] board = new char[n][n];
    init(board);
    backtracking(board, 0);
    return totalNQ;
    }

    private void init(char [][] board) {
        for (int i=0;i<board.length;i++) {
            Arrays.fill(board[i],'.');
        }
    }
    private void backtracking (char [][] board, int rowIndex) {
        if (rowIndex == board.length) {
            totalNQ++;
            System.out.println(totalNQ);
        }
        for (int colIndex =0; colIndex<board.length;colIndex++) {
            if (isValid(board,rowIndex,colIndex)) {
                board[rowIndex][colIndex] = 'Q';
                backtracking(board,rowIndex+1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }
    
    private boolean isValid(char [][] board, int rowIndex, int colIndex) {
        // check 'Q' in the same col from previous row
        for (int j =0; j< rowIndex;j++) {
            if (board[j][colIndex]=='Q') return false;
        }
        // check no 'Q' in diagonal (left side)
        for (int i=rowIndex-1,j=colIndex-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // check no 'Q' in diagnal (right side)
        for (int i=rowIndex-1,j=colIndex+1; i>=0 && j<board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

}

// 1 ms
class Solution {
    int res = 0;
    public int totalNQueens(int n) {
       int []  col = new int[n];
       int [] diag1 = new int[2*n];
        int[] diag2 = new int[2*n];
        
        dfs(0,n,col,diag1,diag2);
        return res;
    }
    
    public void dfs(int i, int n, int [] col, int [] diag1, int [] diag2) {
        if (i==n) {
            res++;
            return;
        }
        
        for (int j=0; j<n;j++) {
            if(col[j]==0 && diag1[j-i+n]==0 && diag2[n*2-i-j-1]==0) {
                col[j] =1;
                diag1[j-i+n] = 1;
                diag2[n*2-i-j-1] = 1;
                dfs(i+1,n, col, diag1, diag2);
                col[j] =0;
                diag1[j-i+n] = 0;
                diag2[n*2-i-j-1] = 0;
            }
        }
    }
}
