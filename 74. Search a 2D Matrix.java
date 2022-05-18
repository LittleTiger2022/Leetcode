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

// a more concise solution
// 0ms
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n==0) return false;
        int m = matrix[0].length;
        if (m==0) return false;
        int l=0, r= m*n-1;
        while (l!=r) {
            int mid = (l+r-1) >> 1;
            if (matrix[mid/m][mid%m]<target)
                l = mid+1;
            else
                r = mid;
        }
        return matrix[r/m][r%m]==target;
    }
}
