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
// 10 ms
class Solution {
 public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    backtrack(new ArrayList<Integer>(), ans, n);
    return ans;
}

private void backtrack(List<Integer> currentQueen, List<List<String>> ans, int n) {
    // 当前皇后的个数是否等于 n 了，等于的话就加到结果中
    if (currentQueen.size() == n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] t = new char[n];
            Arrays.fill(t, '.');
            t[currentQueen.get(i)] = 'Q';
            temp.add(new String(t));
        }
        ans.add(temp);
        return;
    }
    //尝试每一列
    for (int col = 0; col < n; col++) {
        //当前列是否冲突
        if (!currentQueen.contains(col)) {
            //判断对角线是否冲突
            if (isDiagonalAttack(currentQueen, col)) {
                continue;
            }
            //将当前列的皇后加入
            currentQueen.add(col);
            //去考虑下一行的情况
            backtrack(currentQueen, ans, n);
            //将当前列的皇后移除，去判断下一列
            //进入这一步就是两种情况，下边的行走不通了回到这里或者就是已经拿到了一个解回到这里
            currentQueen.remove(currentQueen.size() - 1);
        }

    }

}

private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
    // TODO Auto-generated method stub
    int current_row = currentQueen.size();
    int current_col = i;
    //判断每一行的皇后的情况
    for (int row = 0; row < currentQueen.size(); row++) {
        //左上角的对角线和右上角的对角线，差要么相等，要么互为相反数，直接写成了绝对值
        if (Math.abs(current_row - row) == Math.abs(current_col - currentQueen.get(row))) {
            return true;
        }
    }
    return false;
}
}
