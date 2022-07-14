// solution 1
// 6 ms 100%
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int bit = 0;
        while (left!=right) {
            left>>=1;
            right>>=1;
            ++bit;
        }
        return right<<bit;
    }
}

// solution 2:
// 8ms (78%)
while (right>left) 
right &=(right-1);
return right;
