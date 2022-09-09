//s1
//
class Solution {
    public int integerReplacement(int n) {
       if (n==Integer.MAX_VALUE)
           return 32;
        int count = 0;
        while (n>1) {
            if (n%2==0)
                n/=2;
            else {
                if ((n+1)%4==0 && (n-1 !=2))
                    n++;
                else
                    n--;
            }
            count++;
            }
        return count;
        }
    }
// s2
class Solution {
    public int integerReplacement(int n) {
    int c = 0;
    while (n != 1) {
        if ((n & 1) == 0) {
            n >>>= 1;
        } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
            --n;
        } else {
            ++n;
        }
        ++c;
    }
    return c;    
    }
}
//s3 without use bitCount,
//

class Solution {
    public int integerReplacement(int n) {
    int c = 0;
    while (n != 1) {
        if ((n & 1) == 0) {
            n >>>= 1;
        } else if (n == 3 || (n>>>=1) &1==0 ) {
            --n;
        } else {
            ++n;
        }
        ++c;
    }
    return c;
    }
}

