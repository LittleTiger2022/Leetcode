// my naive solution
class Solution {
    public int maxPoints(int[][] points) {
       int n = points.length;
        if (n<3) return n;
        int slopePair =0;
        slopePair = n*(n-1)/2;
        float [][] slopes = new float [n][n];
        for (int i=0;i<n;i++) slopes[i][i] = -1000.0f;
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                slopes[i][j] = findSlope(points[i][0],points[i][1], points[j][0],points[j][1]);
                slopes[j][i] = slopes[i][j];
      //  System.out.println("count = " + count + " slope = " + slopes[count] + " x1=  " + points[i][0] + " y1 = " + points[i][1] + " x2= " + points[j][0] + " y2 = " + points[j][1]);
           //     count ++;
            }
        }
       // get the maxCount for duplicated number in each row
        int maxCount = 0;
        for (int i=0;i<n;i++) {
            float [] tempRow = slopes[i];
            Arrays.sort(tempRow);
        //    System.out.println(Arrays.toString(tempRow));
                            int tempCount =2;
            for (int j=0;j<n-1;j++) {
                if (tempRow[j+1]==tempRow[j])
                    tempCount++;
                else
                    tempCount=2;
            //    System.out.println(" tempCount = " + tempCount + " maxCount = " + maxCount);
                maxCount = Math.max(maxCount,tempCount);
            }
        }
        return maxCount;
    }
    public float findSlope( int x1, int y1, int x2, int y2) {
        float slope =0;
        if (x1==x2) slope = 10000;
        else 
        slope = (float) (y2-y1)/(x2-x1);
        return slope;
    }
}

// a cleaned version of the above solution
// 12 ms
class Solution {
    public int maxPoints(int[][] points) {
       int n = points.length;
        if (n<3) return n;
        // a matrix to contain slopes
        float [][] slopes = new float [n][n];
        for (int i=0;i<n;i++) slopes[i][i] = -1000.0f; // edge number for self-to-self slope
        
        for (int i=0;i<n-1;i++) {
            for (int j=i+1;j<n;j++) {
                slopes[i][j] = findSlope(points[i][0],points[i][1], points[j][0],points[j][1]);
                slopes[j][i] = slopes[i][j];
            }
        }
       // get the maxCount for duplicated number in each row
        int maxCount = 0;
        for (int i=0;i<n;i++) {
            float [] tempRow = slopes[i];
            Arrays.sort(tempRow);
            int tempCount =2; // start with two pt
            for (int j=0;j<n-1;j++) {
                if (tempRow[j+1]==tempRow[j])
                    tempCount++;
                else
                    tempCount=2;
                maxCount = Math.max(maxCount,tempCount);
            }
        }
        return maxCount;
    }
    public float findSlope( int x1, int y1, int x2, int y2) {
        float slope =0;
        if (x1==x2) slope = 10000; //edge value for divide by zero case
        else 
        slope = (float) (y2-y1)/(x2-x1);
        return slope;
    }
}
