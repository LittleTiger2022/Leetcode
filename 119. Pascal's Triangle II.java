// my naive solution
// trick: for j loop, do it backward to avoid double counting
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        int [] pascal = new int[rowIndex+1];
        pascal[0] = 1;
        res.add(pascal[0]);
        if (rowIndex==0) 
        return res;
        
        for (int i=1;i<=rowIndex;i++) {
            for (int j=i;j>0;j--) {
            pascal[j] = pascal[j-1]+pascal[j];
            }
        }
        for (int i=1;i<=rowIndex;i++)
            res.add(pascal[i]);
        return res;
    }
}
