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

// another simple solution
// 1ms
class Solution
{
    public int divide(int dividend, int divisor)
	{
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        int power = 32;
        long x = Math.abs((long)dividend);
        long y = Math.abs((long)divisor);
        
       while(x >= y)
		{
            while((y << power) > x)
			{
                power--;
            }
            x -= y << power;
            result += 1 << power;
        }
        return result * sign;
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

// another fast way
// 1 ms
class Solution {
     public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow 
         
        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;
        
        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
    }
}
