// 17 ms, my original code (solution 1)
// 0 ms after removing print out parts and corner cases. (see solution 2)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nrow = matrix.length, ncol = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        if(nrow==1) {
            for (int i=0; i<ncol; i++)
            {
             list.add(matrix[0][i]);
            }
            return list;
        }
        if(ncol==1) {
            for (int i=0; i<nrow; i++)
            {
             list.add(matrix[i][0]);
            }
            return list;
        }
        int totalN = nrow*ncol;
        int curRow = 0, curCol = 0, curID = 0;
        
        int switch1 = 0; // 0 ->, 1 down, 2 <-, 3 for up.
        int left=0,right=ncol-1, top=0,bottom = nrow-1;
        
        while (curID<totalN) {
            System.out.println(curID + " switch1 = " + switch1);
            // left to right
            if (switch1==0) {
            for (int i=left; i<=right && curID<totalN; i++) {
                list.add(matrix[top][i]);
                curID++;
            }
                switch1=1; 
                top++;
            }
                        System.out.println(curID + " switch1 = " + switch1);
            // top to bottom
            if (switch1==1) {
                for (int i=top;i<=bottom && curID<totalN;i++) {
                    list.add(matrix[i][right]);
                    curID++;
                }
                switch1=2;
                right--;
            }
                        System.out.println(curID + " switch1 = " + switch1);

            // bottom right to bottom left
            if (switch1==2) {
                for (int i = right;i>=left && curID<totalN;i--) {
                    list.add(matrix[bottom][i]);
                    curID++;
                }
                switch1 =3;
                bottom--;
            }
                        System.out.println(curID + " switch1 = " + switch1);

            if (switch1==3) {
                for (int i = bottom; i >=top && curID<totalN; i--) {
                     list.add(matrix[i][left]);
                      curID++;
                }
                 switch1 =0;
                  left++;
            }
        }
       return list;  
    }
}

// solution 2:
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nrow = matrix.length, ncol = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        
        int totalN = nrow*ncol, curID = 0;
        
        int switch1 = 0; // 0 ->, 1 down, 2 <-, 3 for up.
        int left=0,right=ncol-1, top=0,bottom = nrow-1;
        
        while (curID<totalN) {
            // left to right
            if (switch1==0) {
            for (int i=left; i<=right && curID<totalN; i++) {
                list.add(matrix[top][i]);
                curID++;
            }
                switch1=1; 
                top++;
            }
            // top to bottom
            if (switch1==1) {
                for (int i=top;i<=bottom && curID<totalN;i++) {
                    list.add(matrix[i][right]);
                    curID++;
                }
                switch1=2;
                right--;
            }

            // bottom right to bottom left
            if (switch1==2) {
                for (int i = right;i>=left && curID<totalN;i--) {
                    list.add(matrix[bottom][i]);
                    curID++;
                }
                switch1 =3;
                bottom--;
            }

            if (switch1==3) {
                for (int i = bottom; i >=top && curID<totalN; i--) {
                     list.add(matrix[i][left]);
                      curID++;
                }
                 switch1 =0;
                  left++;
            }
        }
       return list;  
    }
}
// It turns out "switch" is not needed,as I follow the correct order for spiral matrix
// solution 3: clean up switch parts
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nrow = matrix.length, ncol = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        
        int totalN = nrow*ncol, curID = 0;       
        int left=0,right=ncol-1, top=0,bottom = nrow-1;
        
        while (curID<totalN) {
            // left to right
            for (int i=left; i<=right && curID<totalN; i++) {
                list.add(matrix[top][i]);
                curID++;
            }
                top++;
            // top to bottom
                for (int i=top;i<=bottom && curID<totalN;i++) {
                    list.add(matrix[i][right]);
                    curID++;
                }
                right--;

            // bottom right to bottom left
                for (int i = right;i>=left && curID<totalN;i--) {
                    list.add(matrix[bottom][i]);
                    curID++;
                }
                bottom--;

                for (int i = bottom; i >=top && curID<totalN; i--) {
                     list.add(matrix[i][left]);
                      curID++;
                }
                  left++;
        }
       return list;  
    }
}
