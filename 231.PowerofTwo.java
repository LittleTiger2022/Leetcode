// s1
// make use the property of binary of 2 and its power
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
            return false;
        return (n &(n-1)) ==0;
    }
}

// s2
 class Solution {
    public boolean isPowerOfTwo(int n) {
    return n>0 && Integer.bitCount(n)==1;    
    }
}
