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
