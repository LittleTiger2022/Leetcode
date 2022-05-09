// backtrack solution 1
// 4 ms
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<List<String>>();
        boolean[] col = new boolean[n];
        boolean[] lr  = new boolean[n*2];
        boolean[] rl  = new boolean[n*2];
        backtrack(0,n,col,lr,rl,r,new ArrayList<String>());
        return r;
    }
    private static void backtrack (int row, int n, boolean [] col, boolean[] lr, boolean [] rl,
                                  List<List<String>> r, List<String> l) {
        if (row ==n) {
            r.add(new ArrayList<String>(l));
        }
        if (row==n)
            return;
        for (int i=0;i<n;++i) {
            int lrp = row - i + n;
            int rlp = n*2-i-row-1;
            if (col[i]|| lr[lrp] || rl[rlp])
                continue;
            StringBuilder sb = new StringBuilder();
            for (int i1=0;i1<n;++i1) {
                if (i ==i1) {
                    sb.append("Q");
                    continue;
                }
                sb.append(".");
            }
            l.add(sb.toString());
            col[i] = true;
            lr[lrp] = true;
            rl[rlp] = true;
            backtrack(row+1,n,col,lr,rl,r,l);
            l.remove(l.size()-1);
            col[i]  = false;
            lr[lrp] = false;
            rl[rlp] = false;
        }
    }
}

// solution 2
// 3 ms : use solution from happygirlzt https://happygirlzt.com/code/51.html
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char [][] board = new char[n][n];
        init(board);
        helper(board,res,0);
        return res;
    }
    private void init(char [][] board) {
        for (int i=0;i<board.length;i++) {
            Arrays.fill(board[i],'.');
        }
    }
        
     private void helper(char [][] board, List<List<String>> res, int rowIndex) {
         if (rowIndex == board.length) {
             res.add(generate(board));
             return;
         }
         for ( int colIndex=0;colIndex<board.length; colIndex ++) {
             if (isValid(board,rowIndex,colIndex)) {
                 board[rowIndex][colIndex]= 'Q';
                 helper(board,res,rowIndex+1);
                 board[rowIndex][colIndex] = '.';
             }
         }
     }
        
        private boolean isValid(char[][] board, int rowIndex, int colIndex) {
            for (int i=rowIndex-1; i>=0;i--) {
                if (board[i][colIndex]=='Q') return false;
            }
            for (int i=rowIndex-1, j=colIndex-1;i>=0 && j>=0; i--, j-- ) {
                if (board[i][j]=='Q') return false;
            }
            for (int i=rowIndex-1, j=colIndex+1;i>=0 && j<board.length; i--,j++) {
                if (board[i][j]=='Q') return false;
            }
            return true;
        }
        
        private List<String> generate (char[][] board) {
            List<String> list = new ArrayList<>();
            for (char [] row : board) {
                StringBuilder sb = new StringBuilder();
                for (char c: row) sb.append(c);
                list.add(sb.toString());
            }
            return list;
        }
    }
