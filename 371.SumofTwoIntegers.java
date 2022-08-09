// s1
// 0 ms 100% 40Mb 77%
class Solution {
    public int getSum(int a, int b) {
        if (a==0 || b==0)
            return a==0 ? b:a;
        while (b!=0) {
            int carry = a & b;
            a = a ^b;
            b = carry <<1;
        }
        return a;
    }
}
//


