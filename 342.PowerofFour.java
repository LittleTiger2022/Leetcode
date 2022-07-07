// s1
// 2ms
class Solution {
    public boolean isPowerOfFour(int n) {
    if (n<=0)
        return false;
        if (n==1)
        return true;
        boolean res=true;
     while (n>1) {
         if (n%4!=0) {
             res=false;
             break;
         }
         else 
             n=n/4;
     }
        return res;
    }
}

// 12ms convert to 4-bit format, and compare with 10*
class Solution {
    public boolean isPowerOfFour(int n) {
      return Integer.toString(n,4).matches("10*");  
    }
}
