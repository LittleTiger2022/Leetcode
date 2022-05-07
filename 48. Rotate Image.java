// rotation with four points swapping
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0;i<(n+1)/2;i++) {
            for (int j=0;j<n/2;j++){
                int temp= matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1- i][n-j-1];
                matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
// first tranpose, second flip left and right
// 0ms 
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int i=0; i<n; i++) {
            for (int j=i+1;j<n;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // flip left and right
        for (int i=0;i<n;i++) {
            int left =0, right = n-1;
            while (left<right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
        
    }
}
