// s1
//O(n) 1 ms 63%
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length==0)
            return m*n;
        int nAdd = ops.length;
        int cRow = ops[0][0], cCol = ops[0][1];
        for (int i=1;i<nAdd;i++) {
              cRow = Math.min(cRow,ops[i][0]);
              cCol = Math.min(cCol,ops[i][1]);
        }
        return cRow*cCol;
    }
}
