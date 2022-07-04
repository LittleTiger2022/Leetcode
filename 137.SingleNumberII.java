//s1: bit operation
// This question gives a very special case: all numbers appear three times except one number, which appears only one time. So, we can use bit operation to loop through the array. We define two variables: ones to contain appear one time so far, and two is for appear two times so far. any number appears three times will be cancelled out. In the end of the loop, the single number will be kept in ones.
// 0ms, 41Mb (100%)
class Solution {
    public int singleNumber(int[] nums) {
        int ones=0,twos=0;
        for( int num:nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
}

// solution 2
// 

class Solution {
    public int singleNumber(int[] nums) {
        int sum, mask=1, res=0;
        for (int i=0;i<32;++i) {
            sum=0;
            for (int num:nums) {
                sum+=(num>>i) & mask;
                sum %=3;
            }
            res |= sum <<i;
        }
        return res;
    }
}




