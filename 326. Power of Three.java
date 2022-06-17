// without loop
// 23 ms 41%
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n<=0) return false;
        double ratio = Math.log(n)/Math.log(3);
         int x = (int) ratio;
        if (Math.pow(3,x)==n || Math.pow(3,(x+1))==n) return true;
        else 
            return false;
    }
}

// smartest solution
// consider the boundary of integer, the maximum power of 3 inside integer is 3**19 
// 18 ms, 80%
class Solution {
    public boolean isPowerOfThree(int n) {
        return n>0 && 1162261467 % n ==0;
    }
}
