// DFS
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word==null || word.length()==0)
            return true;
        char [] chs = word.toCharArray();
        for (int i=0;i<board.length;i++) 
            for (int j=0;j<board[0].length;j++) 
                if (dfs(board,chs,0,i,j))
                    return true;
        return false;              
    }
    
    private  boolean dfs(char [][] board, char [] words, int idx, int x, int y){
        if (idx==words.length)
            return true;
        if (x<0 || x== board.length || y<0 || y==board[0].length)
            return false;
        if (board[x][y]!=words[idx])
            return false;
        board[x][y]^=256;
        boolean exist = dfs(board,words,idx+1,x,y+1) || dfs(board,words,idx+1,x+1,y)
            || dfs(board,words,idx+1,x-1,y) || dfs(board,words,idx+1,x,y-1);
        board[x][y]^=256;
        return exist;
    }
}
