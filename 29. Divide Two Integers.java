// need to understand how divide algorithm works
// 3 ms

class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0)
            throw new java.lang.ArithmeticException("/ by zero");
        int sign = 1;
        long dividend1=dividend,divisor1=0;
        if (dividend<0 ) {
             sign =-1*sign;
            dividend1 = (long) -1*dividend;
        }
        else dividend1 = (long) dividend;
        if ( divisor<0) {
            sign =-1*sign;
            divisor1 = (long) -1*divisor;
        }
        else divisor1 = (long) divisor;
        
        long result = (long) sign* dividelong(dividend1,divisor1);
        return result > Integer.MAX_VALUE? Integer.MAX_VALUE: (int) result;
    }
    public long dividelong(long dividend1, long divisor1) {
        
        if (dividend1<divisor1) return 0;
        long sum=divisor1,div=1;
            while (sum+sum<=dividend1) {
                sum +=sum;
                div+=div;
            }
        return div + dividelong(dividend1-sum,divisor1);    
    }
}

// improved version without using subroutine
// 1 ms
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor==0)
            throw new java.lang.ArithmeticException("/ by zero");
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int sign = 1;
        long dividend1=0,divisor1=0, res=0;
        if (dividend<0 ) {
             sign =-1*sign;
            dividend1 = (long) -1*dividend;
        }
        else dividend1 = (long) dividend;
        if ( divisor<0) {
            sign =-1*sign;
            divisor1 = (long) -1*divisor;
        }
        else divisor1 = (long) divisor;
        
        while (dividend1>=divisor1) {
             long sum=divisor1,div=1;
             while (sum+sum<=dividend1) {
                sum +=sum;
                div+=div;
            }
            dividend1-=sum;
            res += div;
        }
        return sign* (int) res;
    }
}
