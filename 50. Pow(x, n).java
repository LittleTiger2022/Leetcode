//1ms
class Solution {
    public double myPow(double x, int n) {
            double temp=x;
            int m = (int) n;
        
            if(m==0)
            return 1;
            temp=myPow(x,m/2);
            if(m%2==0)
            return temp*temp;
            else 
            {
            if(m > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }
          
    }
    
}

// avoid overflow
class Solution {
    public double myPow(double x, int n) {

        if(n == 0)
            return 1;
        
        if(n == Integer.MIN_VALUE){
        x = x * x;
        n = n/2;
                 }   
        if(n<0){
          
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
      
// after fix the overflow issue, my original code works
class Solution {
    public double myPow(double x, int n) {
        if (x==0) return 0;
        if (n==0) return 1;

        if(n == Integer.MIN_VALUE){
        x = x * x;
        n = n/2;
        }   

        if (n<0) {
            x = 1/x;
            n = -1*n;
        }
        return (n%2==0) ? myPow(x*x,n /2  ): x*myPow(x*x, n/2);
    }
}
