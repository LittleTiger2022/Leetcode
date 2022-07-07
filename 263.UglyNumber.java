// note: all <=0 numbers are false
// my naive solution
// 2ms 65%
class Solution {
    public boolean isUgly(int n) {
        if (n==1)
            return true;
        if (n<=0)
            return false;
        boolean res;
        res = true;
        while (n>1){
            if ((n%2==0) || (n%3==0) || (n%5==0)) {
                if (n%2==0)
                    n=n/2;
                if (n%3==0)
                    n = n/3;
                if(n%5==0)
                    n=n/5;
            }
            else {
                res = false;
                break;
            }
        }
        return res;
    }
}

// best solution
// 1ms (100%) 39Mb (97%)
class Solution {
    public boolean isUgly(int n) {
        for(int i=2;i<6 && n>0;i++)
            while(n%i==0)
                n/=i;
        return n==1;
    }
}
