// use hashset O(mn)
// 30 ms
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // ruler 1: each row has distic 1-9
        // ruler 2: each col has ...
        // ruler 3: 3x3 sub-boxes has ...
        Set<String> seen = new HashSet<>();
                //
        for (int i = 0; i<9; i++) {
            for (int j =0; j <9; j++) {
                char number = board[i][j];
                if (number !='.')
                    if (!seen.add(number +" in row " +i)
                       || !seen.add(number +" in column " +j)
                       || ! seen.add(number + "in block" + i/3 + "-" + j/3))
                        return false;
            }
            
        }
        return true;
    }
}

//
