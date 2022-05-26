// 1 ms
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        
        for (int i=0;i<numRows;i++) {
            row.add(0,1);
            for (int j=1;j<row.size()-1;j++)
                row.set(j,row.get(j)+row.get(j+1));
            res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}

/solution 2:
// 0 ms
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i=0;i<numRows;i++) {
            row = new ArrayList<Integer>();
            
            for (int j=0;j<=i;j++) 
                if (j==0 || j ==i)
                    row.add(1);
                else
                    row.add(pre.get(j-1)+pre.get(j));
            pre = row;    
            res.add(row);
        }
        return res;
    }
}
