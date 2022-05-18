// 1ms
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int [] rowZero = new int [m];
        int [] colZero = new int [n];
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++ ) {
                if (matrix[i][j]==0) {
                    rowZero[i] = 8;
                    colZero[j] = 8;
                }
            }
        }
        // row to be zero
        for (int i=0;i<m;i++) {
            if (rowZero[i] ==8) {
                for (int j=0;j<n;j++)
                    matrix[i][j] = 0;
            }
        }
        // col to be zero
        for (int i=0;i<n;i++) {
            if (colZero[i]==8) {
                for (int j=0;j<m;j++) {
                    matrix[j][i]=0;
                }
            }
        }
        
    }
}
// another solution
public class Solution {
 public void setZeroes(int[][] matrix) {
     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
     int m = matrix.length, n = matrix[0].length;
     boolean row = false, col = false;
     for (int i = 0; i < m; i++)
         for (int j = 0; j < n; j++){
             if (matrix[i][j] == 0) {
                 matrix[0][j] = 0;
                 matrix[i][0] = 0;
                 if (i == 0) row = true;
                 if (j == 0) col = true;
             }
         }
     for (int i = 1; i < m; i++){
            for (int j = 1; j < n;j++)
         if (matrix[i][0] == 0 || matrix[0][j] == 0){
                 matrix[i][j] = 0;
         }
     }
   
     if (row){
         for (int j = 0; j < n; j++)
             matrix[0][j] = 0;
     }
     if (col){
         for(int i = 0; i < m; i++)
             matrix[i][0] = 0;
     }
 }
 }
