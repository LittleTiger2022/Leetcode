//naive solution
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 1, right = m*n;
        
        while (left<=right) {
            int mid = (left+right)/2;
            int midRow = mid/n;
            int midCol = mid - midRow*n - 1;
            if (midCol<0) {
                midCol=n-1;
                midRow--;
            }
           // System.out.println("left = " + left + " right = " + right + " mid = " + mid +  " midRow = " + midRow + " midCol = " + midCol);
            if (matrix[midRow][midCol]==target)
                return true;
            else if (matrix[midRow][midCol]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return false;
    }
}
