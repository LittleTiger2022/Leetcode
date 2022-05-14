//0 ms
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        if (n==1 & digits[0]<9) {
            digits[0] = digits[0] +1;
            return digits;
        }

        int stopFlag =0, i = n-1;
      //  System.out.println(Arrays.toString(digits) + " stopFlag =" + stopFlag + " i = " + i );
        
        while (stopFlag==0 && i>=0) {
     
            int temp = digits[i]+1;
            if (temp>=10) {
                
                digits[i] = temp -10;
                i--;
                       System.out.println(Arrays.toString(digits) + " stopFlag =" + stopFlag + " i = " + i );

            }  else {
                digits[i] = temp;
                stopFlag =1;
            }
        }
        
        System.out.println(Arrays.toString(digits) + " stopFlag =" + stopFlag + " i = " + i );
        
        if (stopFlag==0 && i <0) {
               int newarr[] = new int[n + 1];
            
             for (int j = 0; j< n; j++)
            newarr[j+1] = digits[j];
               newarr[0] = 1;
            return newarr;
        }
        else {
            return digits;
        }
        
        
    }
}
