//s1
// 60 ms (99%) 50Mb (68%)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0)
        return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int res = Integer.MIN_VALUE;
        
        for (int c=0;c<col;c++) {
            int [] sum = new int [row];
            for (int l=c;l<col;l++) {
                for (int r=0;r<row;r++)
                    sum[r]+=matrix[r][l];
                int cur=0, max=sum[0];
                for (int ele:sum) {
                    cur = Math.max(cur+ele,ele);
                    max = Math.max(max,cur);
                    if (max==k)
                        return k;
                }
                if (max<k) 
                    res = Math.max(res,max);
                else {// max larger than k, check every vertical subarray 
                for (int i =0;i<row;i++) {
                    int curSum=0;
                for (int j=i;j<row;j++) {
                    curSum+=sum[j];
                    if (curSum<=k)
                        res = Math.max(res,curSum);
                  }
                }
                if (res==k)
                    return k;
            }
        }
        }
        return res;
    }
}
